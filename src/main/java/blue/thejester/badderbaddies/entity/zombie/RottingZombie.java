package blue.thejester.badderbaddies.entity.zombie;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.husk.RenderDessicatedHusk;
import blue.thejester.badderbaddies.client.render.zombie.RenderRottingZombie;
import blue.thejester.badderbaddies.entity.husk.EntityMyHusk;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RottingZombie extends EntityMyZombie {
    private static final String NAME = "zombie_rotting";

    public RottingZombie(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 6;
    }

    @Override
    protected int damageBoost() {
        return 2;
    }

    @Override
    protected float magicDamage() {
        return 0;
    }

    //TODO make these also give everyone one
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, RottingZombie.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(RottingZombie.class, RenderRottingZombie.FACTORY);
    }
}
