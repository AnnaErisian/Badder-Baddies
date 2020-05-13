package blue.thejester.badderbaddies.entity.witherskeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.witherskeleton.RenderPearlescentWS;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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

public class PearlescentWS extends EntityMyWitherSkeleton {

    public static String NAME = "witherskeleton_pearlescent";

    public PearlescentWS(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 22;
    }

    @Override
    protected int damageBoost() {
        return 0;
    }

    @Override
    protected float magicDamage() {
        return 3;
    }

    protected PearlescentWS createInstance() {
        return new PearlescentWS(this.world);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
    }

    //TODO make these also give everyone one
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }


    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, PearlescentWS.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = super.attackEntityAsMob(entityIn);
        if (flag && entityIn instanceof EntityLivingBase)
        {
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, 20*15, 1));
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20*15));
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 20*15));
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 20*15));
        }
        return flag;
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(PearlescentWS.class, RenderPearlescentWS.FACTORY);
    }
}
