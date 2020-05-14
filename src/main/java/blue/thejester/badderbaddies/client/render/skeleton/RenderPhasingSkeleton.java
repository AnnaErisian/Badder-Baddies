package blue.thejester.badderbaddies.client.render.skeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.skeleton.PhasingSkeleton;
import blue.thejester.badderbaddies.entity.skeleton.SwiftarmSkeleton;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderPhasingSkeleton extends RenderSkeleton {

    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(BadderBaddies.MODID, "textures/entity/skeleton_phasing.png");

    public RenderPhasingSkeleton(RenderManager renderManager) {
        super(renderManager);
        addLayer(new LayerPhasingCharge(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderPhasingSkeleton.Factory FACTORY = new RenderPhasingSkeleton.Factory();

    public static class Factory implements IRenderFactory<PhasingSkeleton> {
        @Override
        public Render<? super PhasingSkeleton> createRenderFor(RenderManager renderManager) {
            return new RenderPhasingSkeleton(renderManager);
        }
    }
}
