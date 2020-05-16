package blue.thejester.badderbaddies.client.render.enderman;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.enderman.Blenderman;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderEnderman;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderBlenderman extends RenderEnderman {

    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(BadderBaddies.MODID, "textures/entity/enderman_blenderman.png");

    public RenderBlenderman(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnderman entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderBlenderman.Factory FACTORY = new RenderBlenderman.Factory();

    public static class Factory implements IRenderFactory<Blenderman> {
        @Override
        public Render<? super Blenderman> createRenderFor(RenderManager renderManager) {
            return new RenderBlenderman(renderManager);
        }
    }
}
