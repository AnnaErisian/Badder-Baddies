package blue.thejester.badderbaddies.entity.vindicator;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.vindicator.RenderBrutalVindicator;
import blue.thejester.badderbaddies.client.render.vindicator.RenderRevenantVindicator;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class RevenantVindicator extends EntityMyVindicator {

    public static final String NAME = "vindicator_revenant";

    public RevenantVindicator(World worldIn) {
        super(worldIn);
        this.experienceValue += 25;
    }

    @Override
    protected double healthBoost() {
        return 20;
    }

    @Override
    protected int damageBoost() {
        return 0;
    }

    @Override
    protected float magicDamage() {
        return 5;
    }

    protected RevenantVindicator createInstance() {
        return new RevenantVindicator(this.world);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_AXE));
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        this.addPotionEffect(new PotionEffect(MobEffects.HASTE, Integer.MAX_VALUE, 0));
        return super.onInitialSpawn(difficulty, livingdata);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.VINDICATOR_REVENANT;
    }


    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, RevenantVindicator.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(RevenantVindicator.class, RenderRevenantVindicator.FACTORY);
    }
}
