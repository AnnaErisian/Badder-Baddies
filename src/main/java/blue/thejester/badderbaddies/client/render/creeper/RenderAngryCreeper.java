package blue.thejester.badderbaddies.client.render.creeper;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.creeper.AngryCreeper;
import blue.thejester.badderbaddies.entity.skeleton.BarrageSkeleton;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderAngryCreeper extends RenderCreeper {

    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(BadderBaddies.MODID, "textures/entity/creeper_angry.png");

    public RenderAngryCreeper(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCreeper entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderAngryCreeper.Factory FACTORY = new RenderAngryCreeper.Factory();

    public static class Factory implements IRenderFactory<AngryCreeper> {
        @Override
        public Render<? super AngryCreeper> createRenderFor(RenderManager renderManager) {
            return new RenderAngryCreeper(renderManager);
        }
    }
}
