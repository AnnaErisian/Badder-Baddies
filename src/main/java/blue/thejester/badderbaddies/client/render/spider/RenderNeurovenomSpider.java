package blue.thejester.badderbaddies.client.render.spider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.cavespider.DashingCaveSpider;
import blue.thejester.badderbaddies.entity.spider.NeurovenomSpider;
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

public class RenderNeurovenomSpider extends RenderSpider {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/spider_neurovenom.png");

    public RenderNeurovenomSpider(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySpider entity) {
        return TEXTURES;
    }

    public static final RenderNeurovenomSpider.Factory FACTORY = new RenderNeurovenomSpider.Factory();

    public static class Factory implements IRenderFactory<NeurovenomSpider> {
        @Override
        public Render<? super NeurovenomSpider> createRenderFor(RenderManager renderManager) {
            return new RenderNeurovenomSpider(renderManager);
        }
    }
}
