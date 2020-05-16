package blue.thejester.badderbaddies.client.render.witherskeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.witherskeleton.CharredWS;
import blue.thejester.badderbaddies.entity.witherskeleton.WitherPiglin;
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
public class RenderCharredWS extends RenderWitherSkeleton {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/witherskeleton_charred.png");

    public RenderCharredWS(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return TEXTURES;
    }

    public static final RenderCharredWS.Factory FACTORY = new RenderCharredWS.Factory();

    public static class Factory implements IRenderFactory<CharredWS> {
        @Override
        public Render<? super CharredWS> createRenderFor(RenderManager renderManager) {
            return new RenderCharredWS(renderManager);
        }
    }
}
