package blue.thejester.badderbaddies.client.render.witch;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.silverfish.Goldenfish;
import blue.thejester.badderbaddies.entity.witch.PreparedWitch;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSilverfish;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderPreparedWitch extends RenderWitch {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/witch_prepared.png");

    public RenderPreparedWitch(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWitch entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderPreparedWitch.Factory FACTORY = new RenderPreparedWitch.Factory();

    public static class Factory implements IRenderFactory<PreparedWitch> {
        @Override
        public Render<? super PreparedWitch> createRenderFor(RenderManager renderManager) {
            return new RenderPreparedWitch(renderManager);
        }
    }
}
