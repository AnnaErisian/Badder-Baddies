package blue.thejester.badderbaddies.entity.skeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.skeleton.RenderSalvoSkeleton;
import blue.thejester.badderbaddies.entity.LootTables;
import blue.thejester.badderbaddies.entity.ModEntities;
import net.minecraft.entity.monster.EntitySkeleton;
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

public class SalvoSkeleton extends EntityMySkeleton {

    public static final String NAME = "skeleton_salvo";

    public SalvoSkeleton(World worldIn) {
        super(worldIn);
        this.experienceValue += 18;
    }

    @Override
    protected double healthBoost() {
        return 24;
    }

    @Override
    protected double damageBoost() {
        return 2;
    }

    @Override
    protected int magicDamage() {
        return 2;
    }

    @Override
    protected int firingSpeed() {
        return 15;
    }

    @Override
    protected int firingCount() {
        return 5;
    }

    protected SalvoSkeleton createInstance() {
        return new SalvoSkeleton(this.world);
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
        return LootTables.SKELETON_SALVO;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, SalvoSkeleton.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xafafaf, 0x713e4f);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(SalvoSkeleton.class, RenderSalvoSkeleton.FACTORY);
    }
}
