package blue.thejester.badderbaddies.client.render.slime;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class RenderOwnSlime<T extends EntityLiving> extends RenderLiving<T> {

    public RenderOwnSlime(RenderManager p_i47193_1_)
    {
        super(p_i47193_1_, new ModelSlime(16), 0.25F);
        this.addLayer(new LayerSlimeGelCustom(this));
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        EntitySlime entitySlime = (EntitySlime)entity;
        this.shadowSize = 0.25F * (float)entitySlime.getSlimeSize();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    @Override
    protected void preRenderCallback(T entityLivingBase, float partialTickTime)
    {
        EntitySlime entitySlime = (EntitySlime)entityLivingBase;
        float f = 0.999F;
        GlStateManager.scale(0.999F, 0.999F, 0.999F);
        float f1 = (float)entitySlime.getSlimeSize();
        float f2 = (entitySlime.prevSquishFactor + (entitySlime.squishFactor - entitySlime.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }
}
