package blue.thejester.badderbaddies.client.render.slime;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.slime.ShrapnelSlime;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderShrapnelSlime extends RenderOwnSlime<ShrapnelSlime> {

    private static final ResourceLocation SLIME_TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/slime_shrapnel.png");

    public RenderShrapnelSlime(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(ShrapnelSlime entity) {
        return SLIME_TEXTURES;
    }

    public static final RenderShrapnelSlime.Factory FACTORY = new RenderShrapnelSlime.Factory();

    public static class Factory implements IRenderFactory<ShrapnelSlime> {
        @Override
        public Render<? super ShrapnelSlime> createRenderFor(RenderManager renderManager) {
            return new RenderShrapnelSlime(renderManager);
        }
    }
}
