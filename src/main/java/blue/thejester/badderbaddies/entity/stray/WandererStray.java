package blue.thejester.badderbaddies.entity.stray;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.stray.RenderWandererStray;
import net.minecraft.entity.ai.EntityAIAttackRangedBow;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WandererStray extends EntityMyStray {

    public static String NAME = "stray_wanderer";

    private final EntityAIAttackRangedBow<AbstractSkeleton> aiArrowAttack = new EntityAIAttackRangedBow<AbstractSkeleton>(this, 1.0D, 20, 15.0F);

    public WandererStray(World worldIn) {
        super(worldIn);
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
        return 4;
    }

    protected WandererStray createInstance() {
        return new WandererStray(this.world);
    }

    //TODO make these also give everyone one
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    /**
     * sets this entity's combat AI.
     */
    public void setCombatTask()
    {
        if (this.world != null && !this.world.isRemote)
        {
            ItemStack itemstack = this.getHeldItemMainhand();

            if (itemstack.getItem() instanceof net.minecraft.item.ItemBow)
            {
                int i = 7;

                if (this.world.getDifficulty() != EnumDifficulty.HARD)
                {
                    i = 14;
                }

                this.aiArrowAttack.setAttackCooldown(i);
                this.tasks.addTask(4, this.aiArrowAttack);
            }
            else
            {
                super.setCombatTask();
            }
        }
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, WandererStray.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(WandererStray.class, RenderWandererStray.FACTORY);
    }
}
