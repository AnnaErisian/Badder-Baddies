package blue.thejester.badderbaddies.client.render.witherskeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.spider.DashingSpider;
import blue.thejester.badderbaddies.entity.witherskeleton.WitherPiglin;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.client.renderer.entity.RenderWitherSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderWitherPiglin extends RenderWitherSkeleton {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/witherskeleton_piglin.png");

    public RenderWitherPiglin(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return TEXTURES;
    }

    public static final RenderWitherPiglin.Factory FACTORY = new RenderWitherPiglin.Factory();

    public static class Factory implements IRenderFactory<WitherPiglin> {
        @Override
        public Render<? super WitherPiglin> createRenderFor(RenderManager renderManager) {
            return new RenderWitherPiglin(renderManager);
        }
    }
}
