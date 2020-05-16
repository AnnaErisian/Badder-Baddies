package blue.thejester.badderbaddies.client.render.zombie;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.husk.DessicatedHusk;
import blue.thejester.badderbaddies.entity.zombie.ReachingZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderHusk;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderReachingZombie extends RenderHusk {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/zombie_reaching.png");

    public RenderReachingZombie(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityZombie entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderReachingZombie.Factory FACTORY = new RenderReachingZombie.Factory();

    public static class Factory implements IRenderFactory<ReachingZombie> {
        @Override
        public Render<? super ReachingZombie> createRenderFor(RenderManager renderManager) {
            return new RenderReachingZombie(renderManager);
        }
    }
}
