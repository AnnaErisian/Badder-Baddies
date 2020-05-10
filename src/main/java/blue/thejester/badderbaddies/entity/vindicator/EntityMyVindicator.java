package blue.thejester.badderbaddies.entity.vindicator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityMyVindicator extends EntityVindicator {
    public EntityMyVindicator(World worldIn) {
        super(worldIn);
    }

    protected abstract double healthBoost();

    protected abstract int damageBoost();

    protected abstract float magicDamage();

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0D + healthBoost());
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D + damageBoost());
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if(flag) {
            entityIn.attackEntityFrom(DamageSource.causeMobDamage(this).setDamageBypassesArmor(), this.magicDamage());
        }
        return flag;
    }
}
