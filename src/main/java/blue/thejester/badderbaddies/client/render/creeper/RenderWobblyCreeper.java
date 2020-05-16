package blue.thejester.badderbaddies.client.render.creeper;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.creeper.SpeedCreeper;
import blue.thejester.badderbaddies.entity.creeper.WobblyCreeper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderWobblyCreeper extends RenderCreeper {

    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(BadderBaddies.MODID, "textures/entity/creeper_wobbly.png");

    public RenderWobblyCreeper(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCreeper entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderWobblyCreeper.Factory FACTORY = new RenderWobblyCreeper.Factory();

    public static class Factory implements IRenderFactory<WobblyCreeper> {
        @Override
        public Render<? super WobblyCreeper> createRenderFor(RenderManager renderManager) {
            return new RenderWobblyCreeper(renderManager);
        }
    }
}
