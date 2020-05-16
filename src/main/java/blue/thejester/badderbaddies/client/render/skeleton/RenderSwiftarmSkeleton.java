package blue.thejester.badderbaddies.client.render.skeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.skeleton.SwiftarmSkeleton;
import blue.thejester.badderbaddies.entity.witch.BattyWitch;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderSwiftarmSkeleton extends RenderSkeleton {

    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(BadderBaddies.MODID, "textures/entity/skeleton_swiftarm.png");

    public RenderSwiftarmSkeleton(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderSwiftarmSkeleton.Factory FACTORY = new RenderSwiftarmSkeleton.Factory();

    public static class Factory implements IRenderFactory<SwiftarmSkeleton> {
        @Override
        public Render<? super SwiftarmSkeleton> createRenderFor(RenderManager renderManager) {
            return new RenderSwiftarmSkeleton(renderManager);
        }
    }
}
