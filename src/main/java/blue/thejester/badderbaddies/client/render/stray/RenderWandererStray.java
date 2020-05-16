package blue.thejester.badderbaddies.client.render.stray;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.stray.StrongarmStray;
import blue.thejester.badderbaddies.entity.stray.WandererStray;
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
public class RenderWandererStray extends RenderSkeleton {

    private static final ResourceLocation STRAY_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/stray.png");

    public RenderWandererStray(RenderManager renderManager) {
        super(renderManager);
        this.addLayer(new LayerWandererStrayClothing(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return STRAY_SKELETON_TEXTURES;
    }

    public static final RenderWandererStray.Factory FACTORY = new RenderWandererStray.Factory();

    public static class Factory implements IRenderFactory<WandererStray> {
        @Override
        public Render<? super WandererStray> createRenderFor(RenderManager renderManager) {
            return new RenderWandererStray(renderManager);
        }
    }
}
