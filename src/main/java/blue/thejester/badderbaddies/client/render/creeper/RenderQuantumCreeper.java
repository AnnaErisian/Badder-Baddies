package blue.thejester.badderbaddies.client.render.creeper;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.creeper.QuantumCreeper;
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
public class RenderQuantumCreeper extends RenderCreeper {

    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(BadderBaddies.MODID, "textures/entity/creeper_quantum.png");

    public RenderQuantumCreeper(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCreeper entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderQuantumCreeper.Factory FACTORY = new RenderQuantumCreeper.Factory();

    public static class Factory implements IRenderFactory<QuantumCreeper> {
        @Override
        public Render<? super QuantumCreeper> createRenderFor(RenderManager renderManager) {
            return new RenderQuantumCreeper(renderManager);
        }
    }
}
