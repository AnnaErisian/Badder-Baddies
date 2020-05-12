package blue.thejester.badderbaddies.client.render.shulker;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.shulker.AdamantiteShulker;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderShulker;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderAdamantiteShulker extends RenderShulker {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/shulker_adamantite.png");

    public RenderAdamantiteShulker(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityShulker entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderAdamantiteShulker.Factory FACTORY = new RenderAdamantiteShulker.Factory();

    public static class Factory implements IRenderFactory<AdamantiteShulker> {
        @Override
        public Render<? super AdamantiteShulker> createRenderFor(RenderManager renderManager) {
            return new RenderAdamantiteShulker(renderManager);
        }
    }
}
