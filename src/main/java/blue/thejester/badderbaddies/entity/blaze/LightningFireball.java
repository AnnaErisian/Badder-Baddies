package blue.thejester.badderbaddies.entity.blaze;

import blue.thejester.badderbaddies.BadderBaddies;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderShulkerBullet;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LightningFireball extends EntitySmallFireball {
    public static final String NAME = "bb_lightning_fireball";

    public LightningFireball(World worldIn) {
        super(worldIn);
    }

    public LightningFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ)
    {
        super(worldIn, shooter, accelX, accelY, accelZ);
    }

    public LightningFireball(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ)
    {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if(!world.isRemote) {
            if(result != null && result.getBlockPos() != null) {
                world.addWeatherEffect(new EntityLightningBolt(world, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), false));
            } else if(result != null && result.entityHit != null) {
                world.addWeatherEffect(new EntityLightningBolt(world, result.entityHit.posX, result.entityHit.posY, result.entityHit.posZ, false));
            }
        }
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, LightningFireball.class, NAME, id,
                BadderBaddies.instance, 64, 3, true);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(LightningFireball.class, new IRenderFactory<LightningFireball>() {
            @Override
            public Render<? super LightningFireball> createRenderFor(RenderManager manager) {
                return new RenderFireball(manager, 0.3125F);
            }
        });
    }
}
