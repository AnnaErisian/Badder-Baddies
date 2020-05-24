package blue.thejester.badderbaddies.entity.stray;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.stray.RenderStrongarmStray;
import blue.thejester.badderbaddies.client.render.witherskeleton.RenderCharredWS;
import blue.thejester.badderbaddies.entity.LootTables;
import blue.thejester.badderbaddies.entity.witherskeleton.EntityMyWitherSkeleton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
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

public class StrongarmStray extends EntityMyStray {

    public static final String NAME = "stray_strongarm";

    public StrongarmStray(World worldIn) {
        super(worldIn);
        this.experienceValue += 8;
    }

    @Override
    protected double healthBoost() {
        return 6;
    }

    @Override
    protected double damageBoost() {
        return 4;
    }

    @Override
    protected int magicDamage() {
        return 0;
    }

    protected StrongarmStray createInstance() {
        return new StrongarmStray(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.STRAY_STRONGARM;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, StrongarmStray.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x817a60, 0x94979a);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(StrongarmStray.class, RenderStrongarmStray.FACTORY);
    }
}
