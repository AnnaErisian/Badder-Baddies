package blue.thejester.badderbaddies.entity.ghast;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.ghast.RenderSuperFireball;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySuperCreeperFireball extends EntityLargeFireball {

    private static final String NAME = "bb_fireball_biggestexplosive";

    public EntitySuperCreeperFireball(World worldIn) {
        this(worldIn, 6);
    }

    public EntitySuperCreeperFireball(World worldIn, int pow) {
        super(worldIn);
        this.setSize(pow/2f, pow/2f);
        this.explosionPower = pow;
    }

    @SideOnly(Side.CLIENT)
    public EntitySuperCreeperFireball(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ, int pow) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
        this.setSize(pow/2f, pow/2f);
        this.explosionPower = pow;
    }

    public EntitySuperCreeperFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ, int pow) {
        super(worldIn, shooter, accelX, accelY, accelZ);
        this.setSize(pow/2f, pow/2f);
        this.explosionPower = pow;
    }

    protected boolean isFireballFiery()
    {
        return false;
    }

    @Override
    public boolean canRenderOnFire() {
        return false;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, EntitySuperCreeperFireball.class, NAME, id,
                BadderBaddies.instance, 64, 3, true);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySuperCreeperFireball.class, manager -> new RenderSuperFireball(manager, 3f));
    }

}
