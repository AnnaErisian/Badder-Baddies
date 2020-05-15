package blue.thejester.badderbaddies.client.render.creeper;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.creeper.AngryCreeper;
import blue.thejester.badderbaddies.entity.creeper.SpeedCreeper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderSpeedCreeper extends RenderCreeper {

    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(BadderBaddies.MODID, "textures/entity/creeper_speedy.png");

    public RenderSpeedCreeper(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCreeper entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderSpeedCreeper.Factory FACTORY = new RenderSpeedCreeper.Factory();

    public static class Factory implements IRenderFactory<SpeedCreeper> {
        @Override
        public Render<? super SpeedCreeper> createRenderFor(RenderManager renderManager) {
            return new RenderSpeedCreeper(renderManager);
        }
    }
}
