package blue.thejester.badderbaddies.entity.ghast;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.blaze.LightningFireball;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCreeperFireball extends EntityLargeFireball {

    private static final String NAME = "bb_fireball_bigexplosive";

    public EntityCreeperFireball(World worldIn, int pow) {
        super(worldIn);
        this.setSize(pow/2f, pow/2f);
        this.explosionPower = pow;
    }

    public EntityCreeperFireball(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ, int pow) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
        this.setSize(pow/2f, pow/2f);
        this.explosionPower = pow;
    }

    public EntityCreeperFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ, int pow) {
        super(worldIn, shooter, accelX, accelY, accelZ);
        this.setSize(pow/2f, pow/2f);
        this.explosionPower = pow;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, LightningFireball.class, NAME, id,
                BadderBaddies.instance, 64, 3, true);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperFireball.class, new IRenderFactory<EntityCreeperFireball>() {
            @Override
            public Render<? super EntityCreeperFireball> createRenderFor(RenderManager manager) {
                return new RenderFireball(manager, 0.3125F);
            }
        });
    }

}
