package blue.thejester.badderbaddies.client.render.spider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.spider.MotherSpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerSpiderEyes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.function.Predicate;

@SideOnly(Side.CLIENT)
public class RenderMotherSpider extends RenderSpider {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/spider_mother.png");

    public RenderMotherSpider(RenderManager renderManager) {
        super(renderManager);
        this.shadowSize = 1.25f;
        layerRenderers.removeIf(new Predicate<LayerRenderer<EntityCaveSpider>>() {
            @Override
            public boolean test(LayerRenderer<EntityCaveSpider> entityCaveSpiderLayerRenderer) {
                return entityCaveSpiderLayerRenderer instanceof LayerSpiderEyes;
            }
        });

        this.addLayer(new LayerSpiderEyesBlue(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySpider entity) {
        return TEXTURES;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    @Override
    protected void preRenderCallback(EntityLivingBase entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(1.25F, 1.25F, 1.25F);
    }

    public static final RenderMotherSpider.Factory FACTORY = new RenderMotherSpider.Factory();

    public static class Factory implements IRenderFactory<MotherSpider> {
        @Override
        public Render<? super MotherSpider> createRenderFor(RenderManager renderManager) {
            return new RenderMotherSpider(renderManager);
        }
    }
}
