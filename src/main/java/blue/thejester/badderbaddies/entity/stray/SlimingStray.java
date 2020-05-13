package blue.thejester.badderbaddies.entity.stray;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.stray.RenderSlimingStray;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SlimingStray extends EntityMyStray {

    public static String NAME = "stray_sliming";

    public SlimingStray(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 6;
    }

    protected SlimingStray createInstance() {
        return new SlimingStray(this.world);
    }

    //TODO make these also give everyone one
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    protected EntityArrow getArrow(float entity)
    {
        EntityArrow entityarrow = super.getArrow(entity);

        if (entityarrow instanceof EntityTippedArrow)
        {
            ((EntityTippedArrow)entityarrow).addEffect(new PotionEffect(MobEffects.SLOWNESS, 600, 2));
            ((EntityTippedArrow)entityarrow).addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1));
        }

        return entityarrow;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, SlimingStray.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(SlimingStray.class, RenderSlimingStray.FACTORY);
    }
}
