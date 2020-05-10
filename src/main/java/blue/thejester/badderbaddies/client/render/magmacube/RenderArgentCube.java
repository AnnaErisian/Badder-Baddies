package blue.thejester.badderbaddies.client.render.magmacube;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.slime.RenderOwnSlime;
import blue.thejester.badderbaddies.entity.magmacube.ArgentCube;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderMagmaCube;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderArgentCube extends RenderMagmaCube {

    private static final ResourceLocation SLIME_TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/magmacube_argent.png");

    public RenderArgentCube(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMagmaCube entity) {
        return SLIME_TEXTURES;
    }

    public static final RenderArgentCube.Factory FACTORY = new RenderArgentCube.Factory();

    public static class Factory implements IRenderFactory<ArgentCube> {
        @Override
        public Render<? super ArgentCube> createRenderFor(RenderManager renderManager) {
            return new RenderArgentCube(renderManager);
        }
    }
}
