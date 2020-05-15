package blue.thejester.badderbaddies.entity.blaze;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.blaze.RenderThunderBlaze;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ThunderBlaze extends EntityMyBlaze {

    public static String NAME = "blaze_thunder";

    public ThunderBlaze(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 10;
    }

    @Override
    protected double numFireballs() {
        return 1;
    }

    @Override
    protected float magicContactDamage() {
        return 3;
    }

    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(4, new EntityMyBlaze.AIFireballAttack(this, false));
    }

    @Override
    protected EntitySmallFireball createFireball(World world, EntityMyBlaze blaze, double v, double d2, double v1) {
        return new LightningFireball(world, blaze, v, d2, v1);
    }

    protected ThunderBlaze createInstance() {
        return new ThunderBlaze(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, ThunderBlaze.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(ThunderBlaze.class, RenderThunderBlaze.FACTORY);
    }
}
