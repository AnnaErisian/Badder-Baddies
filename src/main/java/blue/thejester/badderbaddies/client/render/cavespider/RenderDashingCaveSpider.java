package blue.thejester.badderbaddies.client.render.cavespider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.spider.LayerSpiderEyesYellow;
import blue.thejester.badderbaddies.entity.cavespider.DashingCaveSpider;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCaveSpider;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerSpiderEyes;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class RenderDashingCaveSpider extends RenderCaveSpider {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/cavespider_dashing.png");

    public RenderDashingCaveSpider(RenderManager renderManager) {
        super(renderManager);
        layerRenderers.removeIf(new Predicate<LayerRenderer<EntityCaveSpider>>() {
            @Override
            public boolean test(LayerRenderer<EntityCaveSpider> entityCaveSpiderLayerRenderer) {
                return entityCaveSpiderLayerRenderer instanceof LayerSpiderEyes;
            }
        });

        this.addLayer(new LayerSpiderEyesYellow(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCaveSpider entity) {
        return TEXTURES;
    }

    public static final RenderDashingCaveSpider.Factory FACTORY = new RenderDashingCaveSpider.Factory();

    public static class Factory implements IRenderFactory<DashingCaveSpider> {
        @Override
        public Render<? super DashingCaveSpider> createRenderFor(RenderManager renderManager) {
            return new RenderDashingCaveSpider(renderManager);
        }
    }
}
