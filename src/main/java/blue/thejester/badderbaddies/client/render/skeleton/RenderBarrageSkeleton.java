package blue.thejester.badderbaddies.client.render.skeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.skeleton.BarrageSkeleton;
import blue.thejester.badderbaddies.entity.skeleton.SalvoSkeleton;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderBarrageSkeleton extends RenderSkeleton {

    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(BadderBaddies.MODID, "textures/entity/skeleton_barrage.png");

    public RenderBarrageSkeleton(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderBarrageSkeleton.Factory FACTORY = new RenderBarrageSkeleton.Factory();

    public static class Factory implements IRenderFactory<BarrageSkeleton> {
        @Override
        public Render<? super BarrageSkeleton> createRenderFor(RenderManager renderManager) {
            return new RenderBarrageSkeleton(renderManager);
        }
    }
}
