package blue.thejester.badderbaddies.client.render.spider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.cavespider.DashingCaveSpider;
import blue.thejester.badderbaddies.entity.spider.LeapingSpider;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCaveSpider;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerSpiderEyes;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class RenderLeapingSpider extends RenderSpider {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/spider_leaping.png");

    public RenderLeapingSpider(RenderManager renderManager) {
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
    protected ResourceLocation getEntityTexture(EntitySpider entity) {
        return TEXTURES;
    }

    public static final RenderLeapingSpider.Factory FACTORY = new RenderLeapingSpider.Factory();

    public static class Factory implements IRenderFactory<LeapingSpider> {
        @Override
        public Render<? super LeapingSpider> createRenderFor(RenderManager renderManager) {
            return new RenderLeapingSpider(renderManager);
        }
    }
}
