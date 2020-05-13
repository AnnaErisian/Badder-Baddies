package blue.thejester.badderbaddies.client.render.stray;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.stray.SlimingStray;
import blue.thejester.badderbaddies.entity.stray.StrongarmStray;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

//TODO put on all the renderers
@SideOnly(Side.CLIENT)
public class RenderSlimingStray extends RenderSkeleton {

    private static final ResourceLocation STRAY_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/stray.png");

    public RenderSlimingStray(RenderManager renderManager) {
        super(renderManager);
        this.addLayer(new LayerSlimingStrayClothing(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return STRAY_SKELETON_TEXTURES;
    }

    public static final RenderSlimingStray.Factory FACTORY = new RenderSlimingStray.Factory();

    public static class Factory implements IRenderFactory<SlimingStray> {
        @Override
        public Render<? super SlimingStray> createRenderFor(RenderManager renderManager) {
            return new RenderSlimingStray(renderManager);
        }
    }
}
