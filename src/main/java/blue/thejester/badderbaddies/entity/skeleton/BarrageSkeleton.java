package blue.thejester.badderbaddies.entity.skeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.skeleton.RenderBarrageSkeleton;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
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
        return 5;
    }

    @Override
    protected int magicDamage() {
        return 3;
    }

    @Override
    protected int firingSpeed() {
        return 10;
    }

    @Override
    protected int firingCount() {
        return 3;
    }

    protected BarrageSkeleton createInstance() {
        return new BarrageSkeleton(this.world);
    }

    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.BOW));
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.SKELETON_BARRAGE;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, BarrageSkeleton.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xafafaf, 0x4f4f4f);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(BarrageSkeleton.class, RenderBarrageSkeleton.FACTORY);
    }
}
