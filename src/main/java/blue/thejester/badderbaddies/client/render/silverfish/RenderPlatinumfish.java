package blue.thejester.badderbaddies.client.render.silverfish;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.silverfish.Goldenfish;
import blue.thejester.badderbaddies.entity.silverfish.Platinumfish;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSilverfish;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderPlatinumfish extends RenderSilverfish {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/silverfish_platinumfish.png");

    public RenderPlatinumfish(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySilverfish entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderPlatinumfish.Factory FACTORY = new RenderPlatinumfish.Factory();

    public static class Factory implements IRenderFactory<Platinumfish> {
        @Override
        public Render<? super Platinumfish> createRenderFor(RenderManager renderManager) {
            return new RenderPlatinumfish(renderManager);
        }
    }
}
