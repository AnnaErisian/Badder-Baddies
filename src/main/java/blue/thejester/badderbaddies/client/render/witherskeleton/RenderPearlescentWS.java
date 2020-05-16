package blue.thejester.badderbaddies.client.render.witherskeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.witherskeleton.CharredWS;
import blue.thejester.badderbaddies.entity.witherskeleton.PearlescentWS;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWitherSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderPearlescentWS extends RenderWitherSkeleton {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/witherskeleton_pearlescent.png");

    public RenderPearlescentWS(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return TEXTURES;
    }

    public static final RenderPearlescentWS.Factory FACTORY = new RenderPearlescentWS.Factory();

    public static class Factory implements IRenderFactory<PearlescentWS> {
        @Override
        public Render<? super PearlescentWS> createRenderFor(RenderManager renderManager) {
            return new RenderPearlescentWS(renderManager);
        }
    }
}
