package blue.thejester.badderbaddies.entity.slime;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityMySlime extends EntitySlime {
    public EntityMySlime(World worldIn) {
        super(worldIn);
    }

    protected abstract double healthBoost(int size);

    protected abstract int damageBoost(int size);

    protected abstract float magicDamage(int size);

    protected void setSlimeSize(int size, boolean resetHealth)
    {
        super.setSlimeSize(size, resetHealth);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(size * size + healthBoost(size)));

        if (resetHealth)
        {
            this.setHealth(this.getMaxHealth());
        }

        this.experienceValue = size;
    }

    /**
     * Gets the amount of damage dealt to the player when "attacked" by the slime.
     */
    protected int getAttackStrength()
    {
        int size = this.getSlimeSize();
        return size + damageBoost(size);
    }

    @Override
    protected void dealDamage(EntityLivingBase entityIn) {
        super.dealDamage(entityIn);
        int size = this.getSlimeSize();
        if (this.canEntityBeSeen(entityIn) && this.getDistanceSq(entityIn) < 0.6D * (double)size * 0.6D * (double)size)
        {
            entityIn.attackEntityFrom(DamageSource.causeMobDamage(this).setDamageBypassesArmor(), this.magicDamage(size));
        }
    }
}
