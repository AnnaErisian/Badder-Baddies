package blue.thejester.badderbaddies.client.render.ghast;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.ghast.ElderGhast;
import blue.thejester.badderbaddies.entity.ghast.GoldenGhast;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderGhast;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderElderGhast extends RenderGhast {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/ghast_elder.png");

    public RenderElderGhast(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGhast entity) {
        return TEXTURES;
    }

    public static final RenderElderGhast.Factory FACTORY = new RenderElderGhast.Factory();

    public static class Factory implements IRenderFactory<ElderGhast> {
        @Override
        public Render<? super ElderGhast> createRenderFor(RenderManager renderManager) {
            return new RenderElderGhast(renderManager);
        }
    }
}
