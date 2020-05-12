package blue.thejester.badderbaddies.client.render.shulker;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.shulker.IronShulker;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderShulker;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderIronShulker extends RenderShulker {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/shulker_iron.png");

    public RenderIronShulker(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityShulker entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderIronShulker.Factory FACTORY = new RenderIronShulker.Factory();

    public static class Factory implements IRenderFactory<IronShulker> {
        @Override
        public Render<? super IronShulker> createRenderFor(RenderManager renderManager) {
            return new RenderIronShulker(renderManager);
        }
    }
}
