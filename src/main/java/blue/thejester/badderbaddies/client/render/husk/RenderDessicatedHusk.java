package blue.thejester.badderbaddies.client.render.husk;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.husk.DessicatedHusk;
import blue.thejester.badderbaddies.entity.husk.Mummy;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderHusk;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderDessicatedHusk extends RenderHusk {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/husk_dessicated.png");

    public RenderDessicatedHusk(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityZombie entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderDessicatedHusk.Factory FACTORY = new RenderDessicatedHusk.Factory();

    public static class Factory implements IRenderFactory<DessicatedHusk> {
        @Override
        public Render<? super DessicatedHusk> createRenderFor(RenderManager renderManager) {
            return new RenderDessicatedHusk(renderManager);
        }
    }
}
