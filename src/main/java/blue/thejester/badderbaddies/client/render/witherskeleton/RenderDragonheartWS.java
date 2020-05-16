package blue.thejester.badderbaddies.client.render.witherskeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.witherskeleton.DragonheartWS;
import blue.thejester.badderbaddies.entity.witherskeleton.PearlescentWS;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWitherSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderDragonheartWS extends RenderWitherSkeleton {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/witherskeleton_dragonheart.png");

    public RenderDragonheartWS(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return TEXTURES;
    }

    public static final RenderDragonheartWS.Factory FACTORY = new RenderDragonheartWS.Factory();

    public static class Factory implements IRenderFactory<DragonheartWS> {
        @Override
        public Render<? super DragonheartWS> createRenderFor(RenderManager renderManager) {
            return new RenderDragonheartWS(renderManager);
        }
    }
}
