package blue.thejester.badderbaddies.entity.blaze;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.blaze.RenderWitherBlaze;
import blue.thejester.badderbaddies.entity.LootTables;
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

public class WitherBlaze extends EntityMyBlaze {

    public static final String NAME = "blaze_wither";

    public WitherBlaze(World worldIn) {
        super(worldIn);
        this.experienceValue += 30;
    }

    @Override
    protected double healthBoost() {
        return 14;
    }

    @Override
    protected double numFireballs() {
        return 1;
    }

    @Override
    protected float magicContactDamage() {
        return 4;
    }

    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(4, new AIFireballAttack(this, false));
    }

    @Override
    protected EntitySmallFireball createFireball(World world, EntityMyBlaze blaze, double v, double d2, double v1) {
        return new WitherFireball(world, blaze, v, d2, v1);
    }

    protected WitherBlaze createInstance() {
        return new WitherBlaze(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.BLAZE_WITHER;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, WitherBlaze.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xe6a601, 0x000000);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(WitherBlaze.class, RenderWitherBlaze.FACTORY);
    }
}
