package blue.thejester.badderbaddies.entity.skeleton;

import blue.thejester.badderbaddies.entity.creeper.EntityMyCreeper;
import blue.thejester.badderbaddies.potion.SimpleHarming;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public abstract class EntityMySkeleton extends EntitySkeleton {

    private final EntityAIAttackRangedBow<AbstractSkeleton> aiArrowAttack = new EntityAIAttackRangedBow<AbstractSkeleton>(this, 1.0D, 20, 15.0F);

    private Field baseArrowAIField = ObfuscationReflectionHelper.findField(AbstractSkeleton.class, "field_85037_d");
    private Field baseMeleeAIField = ObfuscationReflectionHelper.findField(AbstractSkeleton.class, "field_85038_e");
    private EntityAIAttackRangedBow<AbstractSkeleton> baseSkeletonAiArrowAttack;
    private EntityAIAttackMelee baseSkeletonAiMeleeAttack;

    protected abstract double healthBoost();
    protected abstract double damageBoost();
    protected abstract int magicDamage();
    protected abstract int firingSpeed();
    protected abstract int firingCount();

    public EntityMySkeleton(World worldIn) {
        super(worldIn);
        try {
            baseArrowAIField.setAccessible(true);
            baseMeleeAIField.setAccessible(true);
            baseSkeletonAiArrowAttack = (EntityAIAttackRangedBow<AbstractSkeleton>) baseArrowAIField.get(this);
            baseSkeletonAiMeleeAttack = (EntityAIAttackMelee) baseMeleeAIField.get(this);
        } catch (IllegalAccessException e) {
            //What the fuck how are we here
            e.printStackTrace();
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D + healthBoost());
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIRestrictSun(this));
        this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityWolf.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }

    protected EntityArrow getArrow(float p_190726_1_)
    {
        EntityTippedArrow entityarrow = new EntityTippedArrow(this.world, this);
        entityarrow.setDamage(entityarrow.getDamage() + damageBoost());
        entityarrow.setEnchantmentEffectsFromEntity(this, p_190726_1_);

        if (magicDamage() != 0)
        {
            ((EntityTippedArrow)entityarrow).addEffect(new PotionEffect(SimpleHarming.potion, 1, magicDamage()));
        }

        return entityarrow;
    }

    /**
     * sets this entity's combat AI.
     */
    @Override
    public void setCombatTask()
    {
        if (this.world != null && !this.world.isRemote)
        {
            ItemStack itemstack = this.getHeldItemMainhand();

            this.tasks.removeTask(this.baseSkeletonAiArrowAttack);
            this.tasks.removeTask(this.baseSkeletonAiMeleeAttack);
            this.tasks.removeTask(this.aiArrowAttack);

            if (itemstack.getItem() instanceof net.minecraft.item.ItemBow)
            {
                int i = firingSpeed();

                if (this.world.getDifficulty() != EnumDifficulty.HARD)
                {
                    i = firingSpeed() * 2;
                }

                this.aiArrowAttack.setAttackCooldown(i);
                this.tasks.addTask(4, this.aiArrowAttack);
            }
            else
            {
                if(this.baseSkeletonAiMeleeAttack != null) {
                    this.tasks.addTask(4, this.baseSkeletonAiMeleeAttack);
                }
            }
        }
    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor)
    {
        for(int i = 0; i < firingCount(); i++) {
            attackEntityWithRangedAttack(target, distanceFactor, (i)*4);
        }
    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor, float accuracyModifier)
    {
        EntityArrow entityarrow = this.getArrow(distanceFactor);
        if (this.getHeldItemMainhand().getItem() instanceof net.minecraft.item.ItemBow)
            entityarrow = ((net.minecraft.item.ItemBow) this.getHeldItemMainhand().getItem()).customizeArrow(entityarrow);
        double d0 = target.posX - this.posX;
        double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - entityarrow.posY;
        double d2 = target.posZ - this.posZ;
        double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
        entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, accuracyModifier + (float)(14 - this.world.getDifficulty().getId() * 4));
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(entityarrow);
    }
}
