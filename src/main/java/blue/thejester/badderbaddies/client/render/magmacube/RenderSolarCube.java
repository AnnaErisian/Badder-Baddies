package blue.thejester.badderbaddies.client.render.magmacube;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.slime.RenderOwnSlime;
import blue.thejester.badderbaddies.entity.magmacube.SolarCube;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderMagmaCube;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderSolarCube extends RenderMagmaCube {

    private static final ResourceLocation SLIME_TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/magmacube_solar.png");

    public RenderSolarCube(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMagmaCube entity) {
        return SLIME_TEXTURES;
    }

    public static final RenderSolarCube.Factory FACTORY = new RenderSolarCube.Factory();

    public static class Factory implements IRenderFactory<SolarCube> {
        @Override
        public Render<? super SolarCube> createRenderFor(RenderManager renderManager) {
            return new RenderSolarCube(renderManager);
        }
    }
}
