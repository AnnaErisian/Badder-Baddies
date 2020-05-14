package blue.thejester.badderbaddies.entity.skeleton;

import blue.thejester.badderbaddies.potion.SimpleHarming;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRangedBow;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public abstract class EntityMySkeleton extends EntitySkeleton {
    public EntityMySkeleton(World worldIn) {
        super(worldIn);
    }

    private final EntityAIAttackRangedBow<AbstractSkeleton> aiArrowAttack = new EntityAIAttackRangedBow<AbstractSkeleton>(this, 1.0D, 20, 15.0F);

    protected abstract double healthBoost();
    protected abstract double damageBoost();
    protected abstract int magicDamage();
    protected abstract int firingSpeed();
    protected abstract int firingCount();

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D + healthBoost());
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
    public void setCombatTask()
    {
        if (this.world != null && !this.world.isRemote)
        {
            ItemStack itemstack = this.getHeldItemMainhand();

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
                super.setCombatTask();
            }
        }
    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor)
    {
        for(int i = 0; i < firingCount(); i++) {
            super.attackEntityWithRangedAttack(target, distanceFactor);
        }
    }
}
