package blue.thejester.badderbaddies.client.render.skeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.skeleton.SalvoSkeleton;
import blue.thejester.badderbaddies.entity.skeleton.SwiftarmSkeleton;
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
public class RenderSalvoSkeleton extends RenderSkeleton {

    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(BadderBaddies.MODID, "textures/entity/skeleton_salvo.png");

    public RenderSalvoSkeleton(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderSalvoSkeleton.Factory FACTORY = new RenderSalvoSkeleton.Factory();

    public static class Factory implements IRenderFactory<SalvoSkeleton> {
        @Override
        public Render<? super SalvoSkeleton> createRenderFor(RenderManager renderManager) {
            return new RenderSalvoSkeleton(renderManager);
        }
    }
}
