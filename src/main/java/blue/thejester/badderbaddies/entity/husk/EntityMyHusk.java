package blue.thejester.badderbaddies.entity.husk;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityMyHusk extends EntityHusk {
    public EntityMyHusk(World worldIn) {
        super(worldIn);
    }

    protected abstract double healthBoost();

    protected abstract int damageBoost();

    protected abstract float magicDamage();

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D + healthBoost());
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D + damageBoost());
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if(flag) {
            int hrt = entityIn.hurtResistantTime;
            entityIn.hurtResistantTime = 0;
            entityIn.attackEntityFrom(DamageSource.causeMobDamage(this).setDamageBypassesArmor(), this.magicDamage());
            entityIn.hurtResistantTime = hrt;
        }
        return flag;
    }
}
