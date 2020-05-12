package blue.thejester.badderbaddies.entity.blaze;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.blaze.RenderMagmaBlaze;
import blue.thejester.badderbaddies.client.render.vindicator.RenderBrutalVindicator;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
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

public class MagmaBlaze extends EntityMyBlaze {

    public static String NAME = "blaze_magma";

    public MagmaBlaze(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 4;
    }

    @Override
    protected double numFireballs() {
        return 1;
    }

    @Override
    protected float magicContactDamage() {
        return 2;
    }

    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(4, new EntityMyBlaze.AIFireballAttack(this, true));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
    }

    @Override
    protected EntitySmallFireball createFireball(World world, EntityMyBlaze blaze, double v, double d2, double v1) {
        return new EntitySmallFireball(world, blaze, v, d2, v1);
    }

    protected MagmaBlaze createInstance() {
        return new MagmaBlaze(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }


    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, MagmaBlaze.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(MagmaBlaze.class, RenderMagmaBlaze.FACTORY);
    }
}
