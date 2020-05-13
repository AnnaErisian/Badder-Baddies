package blue.thejester.badderbaddies.entity.witherskeleton;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public abstract class EntityMyWitherSkeleton extends EntityWitherSkeleton {
    public EntityMyWitherSkeleton(World worldIn) {
        super(worldIn);
    }

    protected abstract double healthBoost();

    protected abstract int damageBoost();

    protected abstract float magicDamage();

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D + healthBoost());
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D + damageBoost());
    }

    /**
     * Enchants Entity's current equipments based on given DifficultyInstance
     */
    protected void setEnchantmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        float f = difficulty.getClampedAdditionalDifficulty();

        if (!this.getHeldItemMainhand().isEmpty() && this.rand.nextFloat() < 0.25F * f)
        {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, EnchantmentHelper.addRandomEnchantment(this.rand, this.getHeldItemMainhand(), (int)(5.0F + f * (float)this.rand.nextInt(18)), false));
        }
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
