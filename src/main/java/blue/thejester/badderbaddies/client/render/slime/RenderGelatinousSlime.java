package blue.thejester.badderbaddies.client.render.slime;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.slime.GelatinousCube;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderGelatinousSlime extends RenderLiving<GelatinousCube> {

    private static final ResourceLocation SLIME_TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/slime_gelatinous_cube.png");

    public RenderGelatinousSlime(RenderManager p_i47193_1_)
    {
        super(p_i47193_1_, new ModelSlime(16), 0.25F);
        this.addLayer(new LayerSlimeGelCustom(this));
    }


    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    @Override
    protected void preRenderCallback(GelatinousCube entitySlime, float partialTickTime)
    {
        float f = 0.999F;
        GlStateManager.scale(0.999F, 0.999F, 0.999F);
        float f1 = (float)entitySlime.getSlimeSize();
        float f2 = (entitySlime.prevSquishFactor + (entitySlime.squishFactor - entitySlime.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }
    /**
     * Renders the desired {@code T} type Entity.
     */
    @Override
    public void doRender(GelatinousCube entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.enableNormalize();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        this.shadowSize = 0;
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        GlStateManager.disableBlend();
        GlStateManager.disableNormalize();
    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GelatinousCube entity) {
        return SLIME_TEXTURES;
    }

    public static final RenderGelatinousSlime.Factory FACTORY = new RenderGelatinousSlime.Factory();

    public static class Factory implements IRenderFactory<GelatinousCube> {
        @Override
        public Render<? super GelatinousCube> createRenderFor(RenderManager renderManager) {
            return new RenderGelatinousSlime(renderManager);
        }
    }
}
