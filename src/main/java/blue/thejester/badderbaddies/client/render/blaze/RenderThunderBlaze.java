package blue.thejester.badderbaddies.client.render.blaze;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.blaze.ThunderBlaze;
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
public class RenderThunderBlaze extends RenderBlaze {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/blaze_thunder.png");

    public RenderThunderBlaze(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBlaze entity) {
        return TEXTURES;
    }

    public static final RenderThunderBlaze.Factory FACTORY = new RenderThunderBlaze.Factory();

    public static class Factory implements IRenderFactory<ThunderBlaze> {
        @Override
        public Render<? super ThunderBlaze> createRenderFor(RenderManager renderManager) {
            return new RenderThunderBlaze(renderManager);
        }
    }
}
