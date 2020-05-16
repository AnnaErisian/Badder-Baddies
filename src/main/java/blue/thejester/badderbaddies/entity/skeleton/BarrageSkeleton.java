package blue.thejester.badderbaddies.entity.skeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.skeleton.RenderBarrageSkeleton;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BarrageSkeleton extends EntityMySkeleton {

    public static final String NAME = "skeleton_barrage";

    public BarrageSkeleton(World worldIn) {
        super(worldIn);
        this.experienceValue += 14;
    }

    @Override
    protected double healthBoost() {
        return 16;
    }

    @Override
    protected double damageBoost() {
        return 2;
    }

    @Override
    protected int magicDamage() {
        return 1;
    }

    @Override
    protected int firingSpeed() {
        return 20;
    }

    @Override
    protected int firingCount() {
        return 3;
    }

    protected BarrageSkeleton createInstance() {
        return new BarrageSkeleton(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.SKELETON_BARRAGE;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, BarrageSkeleton.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(BarrageSkeleton.class, RenderBarrageSkeleton.FACTORY);
    }
}
