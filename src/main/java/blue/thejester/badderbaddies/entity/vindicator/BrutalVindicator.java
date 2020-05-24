package blue.thejester.badderbaddies.entity.vindicator;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.vindicator.RenderBrutalVindicator;
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

public class BrutalVindicator extends EntityMyVindicator {

    public static final String NAME = "vindicator_brutal";

    public BrutalVindicator(World worldIn) {
        super(worldIn);
        this.experienceValue += 10;
    }

    @Override
    protected double healthBoost() {
        return 10;
    }

    @Override
    protected int damageBoost() {
        return 0;
    }

    @Override
    protected float magicDamage() {
        return 0;
    }

    protected BrutalVindicator createInstance() {
        return new BrutalVindicator(this.world);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_AXE));
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.VINDICATOR_BRUTAL;
    }


    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, BrutalVindicator.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x878c8c, 0x46201c);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(BrutalVindicator.class, RenderBrutalVindicator.FACTORY);
    }
}
