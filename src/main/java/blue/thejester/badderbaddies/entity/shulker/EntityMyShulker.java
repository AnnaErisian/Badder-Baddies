package blue.thejester.badderbaddies.entity.shulker;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class EntityMyShulker extends EntityShulker {
    public EntityMyShulker(World worldIn) {
        super(worldIn);
    }

    protected abstract float magicDamage();

    protected abstract int potionLevel();

    protected abstract int potionTime();

    protected abstract int resistanceLevel();

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new EntityMyShulker.AIAttack());
        this.tasks.addTask(7, new EntityMyShulker.AIPeek());
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityMyShulker.AIAttackNearest(this));
        this.targetTasks.addTask(3, new EntityMyShulker.AIDefenseAttack(this));
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        this.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, Integer.MAX_VALUE/2, resistanceLevel(), false, false));
        return super.onInitialSpawn(difficulty, livingdata);
    }

    class AIAttack extends EntityAIBase
    {
        private int attackTime;

        public AIAttack()
        {
            this.setMutexBits(3);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            EntityLivingBase entitylivingbase = EntityMyShulker.this.getAttackTarget();

            if (entitylivingbase != null && entitylivingbase.isEntityAlive())
            {
                return EntityMyShulker.this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
            }
            else
            {
                return false;
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.attackTime = 20;

            EntityMyShulker.this.updateArmorModifier(100);
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            EntityMyShulker.this.updateArmorModifier(0);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            if (EntityMyShulker.this.world.getDifficulty() != EnumDifficulty.PEACEFUL)
            {
                --this.attackTime;
                EntityLivingBase entitylivingbase = EntityMyShulker.this.getAttackTarget();
                if(entitylivingbase != null) {
                    EntityMyShulker.this.getLookHelper().setLookPositionWithEntity(entitylivingbase, 180.0F, 180.0F);
                    double d0 = EntityMyShulker.this.getDistanceSq(entitylivingbase);

                    if (d0 < 400.0D)
                    {
                        if (this.attackTime <= 0)
                        {
                            this.attackTime = 20 + EntityMyShulker.this.rand.nextInt(10) * 20 / 2;
                            EntityMyShulkerBullet entityshulkerbullet = new EntityMyShulkerBullet(EntityMyShulker.this.world, EntityMyShulker.this, entitylivingbase, EntityMyShulker.this.getAttachmentFacing().getAxis(), magicDamage(), potionLevel(), potionTime());
                            EntityMyShulker.this.world.spawnEntity(entityshulkerbullet);
                            EntityMyShulker.this.playSound(SoundEvents.ENTITY_SHULKER_SHOOT, 2.0F, (EntityMyShulker.this.rand.nextFloat() - EntityMyShulker.this.rand.nextFloat()) * 0.2F + 1.0F);
                        }
                    }
                    else
                    {
                        EntityMyShulker.this.setAttackTarget((EntityLivingBase)null);
                    }
                }


                super.updateTask();
            }
        }
    }
    class AIAttackNearest extends EntityAINearestAttackableTarget<EntityPlayer>
    {
        public AIAttackNearest(EntityShulker shulker)
        {
            super(shulker, EntityPlayer.class, true);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return EntityMyShulker.this.world.getDifficulty() == EnumDifficulty.PEACEFUL ? false : super.shouldExecute();
        }

        protected AxisAlignedBB getTargetableArea(double targetDistance)
        {
            EnumFacing enumfacing = ((EntityMyShulker)this.taskOwner).getAttachmentFacing();

            if (enumfacing.getAxis() == EnumFacing.Axis.X)
            {
                return this.taskOwner.getEntityBoundingBox().grow(4.0D, targetDistance, targetDistance);
            }
            else
            {
                return enumfacing.getAxis() == EnumFacing.Axis.Z ? this.taskOwner.getEntityBoundingBox().grow(targetDistance, targetDistance, 4.0D) : this.taskOwner.getEntityBoundingBox().grow(targetDistance, 4.0D, targetDistance);
            }
        }
    }

    static class AIDefenseAttack extends EntityAINearestAttackableTarget<EntityLivingBase>
    {
        public AIDefenseAttack(EntityMyShulker shulker)
        {
            super(shulker, EntityLivingBase.class, 10, true, false, new Predicate<EntityLivingBase>()
            {
                public boolean apply(@Nullable EntityLivingBase p_apply_1_)
                {
                    return p_apply_1_ instanceof IMob;
                }
            });
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return this.taskOwner.getTeam() == null ? false : super.shouldExecute();
        }

        protected AxisAlignedBB getTargetableArea(double targetDistance)
        {
            EnumFacing enumfacing = ((EntityMyShulker)this.taskOwner).getAttachmentFacing();

            if (enumfacing.getAxis() == EnumFacing.Axis.X)
            {
                return this.taskOwner.getEntityBoundingBox().grow(4.0D, targetDistance, targetDistance);
            }
            else
            {
                return enumfacing.getAxis() == EnumFacing.Axis.Z ? this.taskOwner.getEntityBoundingBox().grow(targetDistance, targetDistance, 4.0D) : this.taskOwner.getEntityBoundingBox().grow(targetDistance, 4.0D, targetDistance);
            }
        }
    }

    class AIPeek extends EntityAIBase
    {
        private int peekTime;

        private AIPeek()
        {
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return EntityMyShulker.this.getAttackTarget() == null && EntityMyShulker.this.rand.nextInt(40) == 0;
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            return EntityMyShulker.this.getAttackTarget() == null && this.peekTime > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.peekTime = 20 * (1 + EntityMyShulker.this.rand.nextInt(3));
            EntityMyShulker.this.updateArmorModifier(30);
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            if (EntityMyShulker.this.getAttackTarget() == null)
            {
                EntityMyShulker.this.updateArmorModifier(0);
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            --this.peekTime;
        }
    }
}
