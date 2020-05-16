package blue.thejester.badderbaddies.client.render.zombie;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.husk.DessicatedHusk;
import blue.thejester.badderbaddies.entity.zombie.MutatedZombie;
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
public class RenderMutatedZombie extends RenderHusk {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/zombie_mutated.png");

    public RenderMutatedZombie(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityZombie entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderMutatedZombie.Factory FACTORY = new RenderMutatedZombie.Factory();

    public static class Factory implements IRenderFactory<MutatedZombie> {
        @Override
        public Render<? super MutatedZombie> createRenderFor(RenderManager renderManager) {
            return new RenderMutatedZombie(renderManager);
        }
    }
}
