package blue.thejester.badderbaddies.entity.witherskeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.vindicator.RenderRevenantVindicator;
import blue.thejester.badderbaddies.client.render.witherskeleton.RenderWitherPiglin;
import blue.thejester.badderbaddies.entity.LootTables;
import blue.thejester.badderbaddies.entity.vindicator.EntityMyVindicator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class WitherPiglin extends EntityMyWitherSkeleton {

    public static final String NAME = "witherskeleton_piglin";

    public WitherPiglin(World worldIn) {
        super(worldIn);
        this.experienceValue += 5;
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

    protected WitherPiglin createInstance() {
        return new WitherPiglin(this.world);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.WITHER_SKELETON_PIGLIN;
    }


    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, WitherPiglin.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = super.attackEntityAsMob(entityIn);
        if (flag && entityIn instanceof EntityLivingBase)
        {
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, 20*15));
        }
        return flag;
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(WitherPiglin.class, RenderWitherPiglin.FACTORY);
    }
}
