package blue.thejester.badderbaddies.client.render.ghast;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.blaze.ThunderBlaze;
import blue.thejester.badderbaddies.entity.ghast.GoldenGhast;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBlaze;
import net.minecraft.client.renderer.entity.RenderGhast;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderGoldenGhast extends RenderGhast {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/ghast_golden.png");

    public RenderGoldenGhast(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGhast entity) {
        return TEXTURES;
    }

    public static final RenderGoldenGhast.Factory FACTORY = new RenderGoldenGhast.Factory();

    public static class Factory implements IRenderFactory<GoldenGhast> {
        @Override
        public Render<? super GoldenGhast> createRenderFor(RenderManager renderManager) {
            return new RenderGoldenGhast(renderManager);
        }
    }
}
