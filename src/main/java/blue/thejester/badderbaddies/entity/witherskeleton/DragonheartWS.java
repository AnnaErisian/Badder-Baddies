package blue.thejester.badderbaddies.entity.witherskeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.witherskeleton.RenderDragonheartWS;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Blocks;
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

public class DragonheartWS extends EntityMyWitherSkeleton {

    public static final String NAME = "witherskeleton_dragonheart";

    public DragonheartWS(World worldIn) {
        super(worldIn);
        this.experienceValue += 20;
    }

    @Override
    protected double healthBoost() {
        return 34;
    }

    @Override
    protected int damageBoost() {
        return 0;
    }

    @Override
    protected float magicDamage() {
        return 5;
    }

    protected DragonheartWS createInstance() {
        return new DragonheartWS(this.world);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
        ItemStack helm = new ItemStack(Items.LEATHER_HELMET);
        Items.LEATHER_HELMET.setColor(helm, 3545413);
        this.setItemStackToSlot(EntityEquipmentSlot.HEAD, helm);
        this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0F;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.WITHER_SKELETON_DRAGONHEART;
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        //This doesn't actually help but it gives the potion particles and that's scary uwu
        this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, Integer.MAX_VALUE, 0));
        return super.onInitialSpawn(difficulty, livingdata);
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, DragonheartWS.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x341443, 0x141414);
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = super.attackEntityAsMob(entityIn);
        if (flag && entityIn instanceof EntityLivingBase)
        {
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, 20*10, 2));
        }
        return flag;
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(DragonheartWS.class, RenderDragonheartWS.FACTORY);
    }
}
