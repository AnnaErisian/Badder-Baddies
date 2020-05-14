package blue.thejester.badderbaddies.entity.creeper;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.creeper.RenderSpeedCreeper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SpeedCreeper extends EntityMyCreeper {

    public static String NAME = "creeper_speed";

    public SpeedCreeper(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 8;
    }

    @Override
    protected int fuseTimer() {
        return 25;
    }

    protected SpeedCreeper createInstance() {
        return new SpeedCreeper(this.world);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3125D);
    }

    //TODO make these also give everyone one
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, SpeedCreeper.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(SpeedCreeper.class, RenderSpeedCreeper.FACTORY);
    }
}
