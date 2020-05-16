package blue.thejester.badderbaddies.client.render.witch;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.witch.BattyWitch;
import blue.thejester.badderbaddies.entity.witch.PreparedWitch;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderBattyWitch extends RenderWitch {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/witch_batty.png");

    public RenderBattyWitch(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWitch entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderBattyWitch.Factory FACTORY = new RenderBattyWitch.Factory();

    public static class Factory implements IRenderFactory<BattyWitch> {
        @Override
        public Render<? super BattyWitch> createRenderFor(RenderManager renderManager) {
            return new RenderBattyWitch(renderManager);
        }
    }
}
