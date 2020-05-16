package blue.thejester.badderbaddies.client.render.husk;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.husk.Mummy;
import blue.thejester.badderbaddies.entity.vindicator.BrutalVindicator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderHusk;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVindicator;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderMummy extends RenderHusk {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/husk_mummy.png");

    public RenderMummy(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityZombie entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderMummy.Factory FACTORY = new RenderMummy.Factory();

    public static class Factory implements IRenderFactory<Mummy> {
        @Override
        public Render<? super Mummy> createRenderFor(RenderManager renderManager) {
            return new RenderMummy(renderManager);
        }
    }
}
