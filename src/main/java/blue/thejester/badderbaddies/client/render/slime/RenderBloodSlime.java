package blue.thejester.badderbaddies.client.render.slime;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.slime.BloodSlime;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderBloodSlime extends RenderOwnSlime<BloodSlime> {

    private static final ResourceLocation SLIME_TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/slime_blood.png");

    public RenderBloodSlime(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(BloodSlime entity) {
        return SLIME_TEXTURES;
    }

    public static final RenderBloodSlime.Factory FACTORY = new RenderBloodSlime.Factory();

    public static class Factory implements IRenderFactory<BloodSlime> {
        @Override
        public Render<? super BloodSlime> createRenderFor(RenderManager renderManager) {
            return new RenderBloodSlime(renderManager);
        }
    }
}
