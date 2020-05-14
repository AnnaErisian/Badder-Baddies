package blue.thejester.badderbaddies.client.render.zombie;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.husk.DessicatedHusk;
import blue.thejester.badderbaddies.entity.zombie.PlagueZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderHusk;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderPlagueZombie extends RenderHusk {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/zombie_plague.png");

    public RenderPlagueZombie(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityZombie entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderPlagueZombie.Factory FACTORY = new RenderPlagueZombie.Factory();

    public static class Factory implements IRenderFactory<PlagueZombie> {
        @Override
        public Render<? super PlagueZombie> createRenderFor(RenderManager renderManager) {
            return new RenderPlagueZombie(renderManager);
        }
    }
}
