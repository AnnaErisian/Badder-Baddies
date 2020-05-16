package blue.thejester.badderbaddies.client.render.blaze;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.blaze.MagmaBlaze;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBlaze;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderMagmaBlaze extends RenderBlaze {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/blaze_magma.png");

    public RenderMagmaBlaze(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBlaze entity) {
        return TEXTURES;
    }

    public static final RenderMagmaBlaze.Factory FACTORY = new RenderMagmaBlaze.Factory();

    public static class Factory implements IRenderFactory<MagmaBlaze> {
        @Override
        public Render<? super MagmaBlaze> createRenderFor(RenderManager renderManager) {
            return new RenderMagmaBlaze(renderManager);
        }
    }
}
