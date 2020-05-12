package blue.thejester.badderbaddies.client.render.ghast;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.ghast.GoldenGhast;
import blue.thejester.badderbaddies.entity.ghast.QuartzGhast;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderGhast;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderQuartzGhast extends RenderGhast {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/ghast_quartz.png");

    public RenderQuartzGhast(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGhast entity) {
        return TEXTURES;
    }

    public static final RenderQuartzGhast.Factory FACTORY = new RenderQuartzGhast.Factory();

    public static class Factory implements IRenderFactory<QuartzGhast> {
        @Override
        public Render<? super QuartzGhast> createRenderFor(RenderManager renderManager) {
            return new RenderQuartzGhast(renderManager);
        }
    }
}
