package blue.thejester.badderbaddies.client.render.cavespider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.cavespider.DashingCaveSpider;
import blue.thejester.badderbaddies.entity.cavespider.TinyJerk;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCaveSpider;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderTinyJerk extends RenderCaveSpider {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/cavespider_jerk.png");

    public RenderTinyJerk(RenderManager renderManager) {
        super(renderManager);
        this.shadowSize *= 0.5F;
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCaveSpider entity) {
        return TEXTURES;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    @Override
    protected void preRenderCallback(EntityCaveSpider entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(0.35F, 0.35F, 0.35F);
    }

    public static final RenderTinyJerk.Factory FACTORY = new RenderTinyJerk.Factory();

    public static class Factory implements IRenderFactory<TinyJerk> {
        @Override
        public Render<? super TinyJerk> createRenderFor(RenderManager renderManager) {
            return new RenderTinyJerk(renderManager);
        }
    }
}
