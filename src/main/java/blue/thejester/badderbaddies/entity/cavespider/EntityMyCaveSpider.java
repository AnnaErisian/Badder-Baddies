package blue.thejester.badderbaddies.entity.cavespider;

import blue.thejester.badderbaddies.entity.ai.EntityAIBigLeapAtTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public abstract class EntityMyCaveSpider extends EntityCaveSpider {
    public EntityMyCaveSpider(World worldIn) {
        super(worldIn);
        this.setSize(0.7F * sizeChange(), 0.5F * sizeChange());
    }

    protected abstract double healthBoost();

    protected abstract int damageBoost();

    protected abstract float magicDamage();

    protected abstract float speedMult();

    protected abstract float sizeChange();

    protected abstract int poisonLevel();

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D + healthBoost());
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D * speedMult());
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D + damageBoost());
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if(flag) {
            int hrt = entityIn.hurtResistantTime;
            entityIn.hurtResistantTime = 0;
            entityIn.attackEntityFrom(DamageSource.causeMobDamage(this).setDamageBypassesArmor(), this.magicDamage());
            entityIn.hurtResistantTime = hrt;

            int i = 0;

            if (this.world.getDifficulty() == EnumDifficulty.NORMAL)
            {
                i = 7;
            }
            else if (this.world.getDifficulty() == EnumDifficulty.HARD)
            {
                i = 15;
            }

            if (i > 0)
            {
                ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, i * 20, poisonLevel()));
            }
        }
        return flag;
    }
}
