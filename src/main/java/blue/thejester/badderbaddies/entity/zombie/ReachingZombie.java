package blue.thejester.badderbaddies.entity.zombie;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.zombie.RenderReachingZombie;
import blue.thejester.badderbaddies.client.render.zombie.RenderRottingZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ReachingZombie extends EntityMyZombie {
    private static final String NAME = "zombie_reaching";

    public ReachingZombie(World worldIn) {
        super(worldIn);
        this.width *= 1.75;
    }

    @Override
    protected double healthBoost() {
        return 10;
    }

    @Override
    protected int damageBoost() {
        return 4;
    }

    @Override
    protected float magicDamage() {
        return 2;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, ReachingZombie.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(ReachingZombie.class, RenderReachingZombie.FACTORY);
    }
}
