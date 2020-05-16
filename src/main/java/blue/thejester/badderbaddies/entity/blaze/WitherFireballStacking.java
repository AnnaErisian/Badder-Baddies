package blue.thejester.badderbaddies.entity.blaze;

import blue.thejester.badderbaddies.BadderBaddies;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WitherFireballStacking extends EntitySmallFireball {
    public static final String NAME = "bb_witherer_fireball";

    public WitherFireballStacking(World worldIn) {
        super(worldIn);
    }

    public WitherFireballStacking(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ)
    {
        super(worldIn, shooter, accelX, accelY, accelZ);
    }

    public WitherFireballStacking(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ)
    {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote) {
            if (result.entityHit != null) {
                if (!result.entityHit.isImmuneToFire()) {
                    boolean flag = result.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0F);
                    if (flag) {
                        this.applyEnchantments(this.shootingEntity, result.entityHit);
                        if(result.entityHit instanceof EntityLivingBase) {
                            EntityLivingBase entity = ((EntityLivingBase) result.entityHit);
                            PotionEffect pot = entity.getActivePotionEffect(MobEffects.WITHER);
                            if(pot == null) {
                                entity.addPotionEffect(new PotionEffect(MobEffects.WITHER, 100));
                            } else {
                                entity.addPotionEffect(new PotionEffect(MobEffects.WITHER, Math.max(100, pot.getDuration()), pot.getAmplifier() + 1));
                            }
                        }
                    }
                }
            }
            this.setDead();
        }
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, WitherFireballStacking.class, NAME, id,
                BadderBaddies.instance, 64, 3, true);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(WitherFireballStacking.class, new IRenderFactory<WitherFireballStacking>() {
            @Override
            public Render<? super WitherFireballStacking> createRenderFor(RenderManager manager) {
                return new RenderFireball(manager, 0.3125F);
            }
        });
    }
}
