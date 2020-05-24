package blue.thejester.badderbaddies.entity.witherskeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.witherskeleton.RenderCharredWS;
import blue.thejester.badderbaddies.entity.LootTables;
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

public class CharredWS extends EntityMyWitherSkeleton {

    public static final String NAME = "witherskeleton_charred";

    public CharredWS(World worldIn) {
        super(worldIn);
        this.experienceValue += 9;
    }

    @Override
    protected double healthBoost() {
        return 16;
    }

    @Override
    protected int damageBoost() {
        return 0;
    }

    @Override
    protected float magicDamage() {
        return 1;
    }

    protected CharredWS createInstance() {
        return new CharredWS(this.world);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.WITHER_SKELETON_CHARRED;
    }


    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, CharredWS.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x141414, 0x090909);
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = super.attackEntityAsMob(entityIn);
        if (flag && entityIn instanceof EntityLivingBase)
        {
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, 20*15));
            entityIn.setFire(15);
        }
        return flag;
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(CharredWS.class, RenderCharredWS.FACTORY);
    }
}
