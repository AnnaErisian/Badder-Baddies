package blue.thejester.badderbaddies.entity.ghast;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.blaze.RenderTurboBlaze;
import blue.thejester.badderbaddies.client.render.ghast.RenderQuartzGhast;
import blue.thejester.badderbaddies.entity.LootTables;
import blue.thejester.badderbaddies.entity.blaze.TurboBlaze;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class QuartzGhast extends EntityMyGhast {
    public static final String NAME = "ghast_quartz";

    public QuartzGhast(World worldIn) {
        super(worldIn);
        this.experienceValue += 5;
    }

    @Override
    protected double healthBoost() {
        return 16;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.GHAST_QUARTZ;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, QuartzGhast.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xe9e9e9, 0x636363);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(QuartzGhast.class, RenderQuartzGhast.FACTORY);
    }
}
