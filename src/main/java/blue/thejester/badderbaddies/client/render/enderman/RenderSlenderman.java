package blue.thejester.badderbaddies.client.render.enderman;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.enderman.Slenderman;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEnderman;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderSlenderman extends RenderEnderman {

    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(BadderBaddies.MODID, "textures/entity/enderman_slenderman.png");

    public RenderSlenderman(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnderman entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderSlenderman.Factory FACTORY = new RenderSlenderman.Factory();

    public static class Factory implements IRenderFactory<Slenderman> {
        @Override
        public Render<? super Slenderman> createRenderFor(RenderManager renderManager) {
            return new RenderSlenderman(renderManager);
        }
    }
}
