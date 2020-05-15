package blue.thejester.badderbaddies.entity.enderman;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.enderman.RenderBlenderman;
import blue.thejester.badderbaddies.client.render.enderman.RenderRenderman;
import com.google.common.base.Predicates;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Renderman extends EntityMyEnderman {

    public static String NAME = "enderman_renderman";

    public Renderman(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 40;
    }

    @Override
    protected int damageBoost() {
        return 6;
    }

    @Override
    protected float magicDamage() {
        return 4;
    }

    protected Renderman createInstance() {
        return new Renderman(this.world);
    }

    //TODO make these also give everyone one
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, Renderman.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(Renderman.class, RenderRenderman.FACTORY);
    }
}
