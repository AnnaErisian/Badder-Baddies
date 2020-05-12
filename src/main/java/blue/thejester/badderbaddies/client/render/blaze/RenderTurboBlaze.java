package blue.thejester.badderbaddies.client.render.blaze;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.blaze.TurboBlaze;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBlaze;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderTurboBlaze extends RenderBlaze {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/blaze_turbo.png");

    public RenderTurboBlaze(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBlaze entity) {
        return TEXTURES;
    }

    public static final RenderTurboBlaze.Factory FACTORY = new RenderTurboBlaze.Factory();

    public static class Factory implements IRenderFactory<TurboBlaze> {
        @Override
        public Render<? super TurboBlaze> createRenderFor(RenderManager renderManager) {
            return new RenderTurboBlaze(renderManager);
        }
    }
}
