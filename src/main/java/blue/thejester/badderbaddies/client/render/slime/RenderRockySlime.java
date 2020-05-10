package blue.thejester.badderbaddies.client.render.slime;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.slime.RockySlime;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderRockySlime extends RenderOwnSlime<RockySlime> {

    private static final ResourceLocation SLIME_TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/slime_rocky.png");

    public RenderRockySlime(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(RockySlime entity) {
        return SLIME_TEXTURES;
    }

    public static final RenderRockySlime.Factory FACTORY = new RenderRockySlime.Factory();

    public static class Factory implements IRenderFactory<RockySlime> {
        @Override
        public Render<? super RockySlime> createRenderFor(RenderManager renderManager) {
            return new RenderRockySlime(renderManager);
        }
    }
}
