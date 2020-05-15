package blue.thejester.badderbaddies.client.render.cavespider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.spider.LayerSpiderEyesGreen;
import blue.thejester.badderbaddies.entity.cavespider.LeapingCaveSpider;
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

public class RenderLeapingCaveSpider extends RenderCaveSpider {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/cavespider_leaping.png");

    public RenderLeapingCaveSpider(RenderManager renderManager) {
        super(renderManager);
        layerRenderers.removeIf(new Predicate<LayerRenderer<EntityCaveSpider>>() {
            @Override
            public boolean test(LayerRenderer<EntityCaveSpider> entityCaveSpiderLayerRenderer) {
                return entityCaveSpiderLayerRenderer instanceof LayerSpiderEyes;
            }
        });

        this.addLayer(new LayerSpiderEyesGreen(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCaveSpider entity) {
        return TEXTURES;
    }

    public static final RenderLeapingCaveSpider.Factory FACTORY = new RenderLeapingCaveSpider.Factory();

    public static class Factory implements IRenderFactory<LeapingCaveSpider> {
        @Override
        public Render<? super LeapingCaveSpider> createRenderFor(RenderManager renderManager) {
            return new RenderLeapingCaveSpider(renderManager);
        }
    }
}
