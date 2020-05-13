package blue.thejester.badderbaddies.entity.stray;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.stray.RenderStrongarmStray;
import blue.thejester.badderbaddies.client.render.witherskeleton.RenderCharredWS;
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

    public static String NAME = "stray_strongarm";

    public StrongarmStray(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 6;
    }

    protected StrongarmStray createInstance() {
        return new StrongarmStray(this.world);
    }

    //TODO make these also give everyone one
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    protected EntityArrow getArrow(float entity)
    {
        EntityArrow entityarrow = super.getArrow(entity);

        entityarrow.setDamage(entityarrow.getDamage() + 4);

        return entityarrow;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, StrongarmStray.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(StrongarmStray.class, RenderStrongarmStray.FACTORY);
    }
}
