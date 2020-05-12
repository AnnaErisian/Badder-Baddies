package blue.thejester.badderbaddies.client.render.witch;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.witch.CovenMatron;
import blue.thejester.badderbaddies.entity.witch.PreparedWitch;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderCovenMatron extends RenderWitch {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/witch_coven_matron.png");

    public RenderCovenMatron(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWitch entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderCovenMatron.Factory FACTORY = new RenderCovenMatron.Factory();

    public static class Factory implements IRenderFactory<CovenMatron> {
        @Override
        public Render<? super CovenMatron> createRenderFor(RenderManager renderManager) {
            return new RenderCovenMatron(renderManager);
        }
    }
}
