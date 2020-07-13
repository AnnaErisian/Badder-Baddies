package blue.thejester.badderbaddies.entity.skeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.skeleton.RenderSwiftarmSkeleton;
import blue.thejester.badderbaddies.config.SpawnWeights;
import blue.thejester.badderbaddies.entity.LootTables;
import blue.thejester.badderbaddies.entity.ModEntities;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SwiftarmSkeleton extends EntityMySkeleton {

    public static final String NAME = "skeleton_swiftarm";

    public SwiftarmSkeleton(World worldIn) {
        super(worldIn);
        this.experienceValue += 3;
    }

    @Override
    protected double healthBoost() {
        return 6;
    }

    @Override
    protected double damageBoost() {
        return 2;
    }

    @Override
    protected int magicDamage() {
        return 0;
    }

    @Override
    protected int firingSpeed() {
        return 0;
    }

    @Override
    protected int firingCount() {
        return 1;
    }

    protected SwiftarmSkeleton createInstance() {
        return new SwiftarmSkeleton(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.SKELETON_SWIFTARM;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, SwiftarmSkeleton.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xababab, 0xdbdbdb);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(SwiftarmSkeleton.class, RenderSwiftarmSkeleton.FACTORY);
    }
}
