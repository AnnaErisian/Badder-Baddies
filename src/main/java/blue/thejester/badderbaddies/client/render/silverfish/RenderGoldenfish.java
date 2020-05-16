package blue.thejester.badderbaddies.client.render.silverfish;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.silverfish.Goldenfish;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSilverfish;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderGoldenfish extends RenderSilverfish {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/silverfish_goldenfish.png");

    public RenderGoldenfish(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySilverfish entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderGoldenfish.Factory FACTORY = new RenderGoldenfish.Factory();

    public static class Factory implements IRenderFactory<Goldenfish> {
        @Override
        public Render<? super Goldenfish> createRenderFor(RenderManager renderManager) {
            return new RenderGoldenfish(renderManager);
        }
    }
}
