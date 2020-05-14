package blue.thejester.badderbaddies.entity.stray;

import blue.thejester.badderbaddies.potion.SimpleHarming;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public abstract class EntityMyStray extends EntityStray {
    public EntityMyStray(World worldIn) {
        super(worldIn);
    }

    protected abstract double healthBoost();
    protected abstract double damageBoost();
    protected abstract int magicDamage();

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D + healthBoost());
    }

    protected EntityArrow getArrow(float entity)
    {
        EntityArrow entityarrow = super.getArrow(entity);

        entityarrow.setDamage(entityarrow.getDamage() + damageBoost());

        if (magicDamage() != 0 && entityarrow instanceof EntityTippedArrow)
        {
            ((EntityTippedArrow)entityarrow).addEffect(new PotionEffect(SimpleHarming.potion, 1, magicDamage()));
        }

        return entityarrow;
    }

}
