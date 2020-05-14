package blue.thejester.badderbaddies.entity.creeper;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public abstract class EntityMyCreeper extends EntityCreeper {

    private Field fuseTimeField = ObfuscationReflectionHelper.findField(EntityMyCreeper.class.getSuperclass(), "field_82225_f");

    protected abstract double healthBoost();
    protected abstract int fuseTimer();

    public EntityMyCreeper(World worldIn) {
        super(worldIn);
        try {
            fuseTimeField.setAccessible(true);
            fuseTimeField.setInt(this, fuseTimer());
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
}
