package blue.thejester.badderbaddies.entity.ghast;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.blaze.RenderTurboBlaze;
import blue.thejester.badderbaddies.client.render.ghast.RenderQuartzGhast;
import blue.thejester.badderbaddies.entity.blaze.TurboBlaze;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class QuartzGhast extends EntityMyGhast {
    private static final String NAME = "ghast_quartz";

    public QuartzGhast(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 16;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, QuartzGhast.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(QuartzGhast.class, RenderQuartzGhast.FACTORY);
    }
}
