package blue.thejester.badderbaddies.entity.shulker;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.magmacube.RenderSolarCube;
import blue.thejester.badderbaddies.client.render.shulker.RenderDiamondShulker;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderShulkerBullet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityMyShulkerBullet extends EntityShulkerBullet {
    public static final String NAME = "bb_shulker_bullet";
    private EntityMyShulker owner;
    private float magicDamage;
    private int potLevel;
    private int potTime;

    public EntityMyShulkerBullet(World worldIn, double x, double y, double z, double motionXIn, double motionYIn, double motionZIn) {
        super(worldIn, x, y, z, motionXIn, motionYIn, motionZIn);
    }

    public EntityMyShulkerBullet(World worldIn, EntityMyShulker ownerIn, Entity targetIn, EnumFacing.Axis p_i46772_4_, float magicDamage, int potLevel, int potTime) {
        super(worldIn, ownerIn, targetIn, p_i46772_4_);
        this.owner = ownerIn;
        this.magicDamage = magicDamage;
        this.potLevel = potLevel;
        this.potTime = potTime;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);

        compound.setFloat("mDmg", this.magicDamage);
        compound.setInteger("potL", this.potLevel);
        compound.setInteger("potD", this.potTime);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound compound)
    {
        this.potTime = compound.getInteger("potD");
        this.potLevel = compound.getInteger("potL");
        this.magicDamage = compound.getInteger("mDmg");

        super.readEntityFromNBT(compound);
    }

    protected void bulletHit(RayTraceResult result)
    {
        if (result.entityHit == null)
        {
            ((WorldServer)this.world).spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX, this.posY, this.posZ, 2, 0.2D, 0.2D, 0.2D, 0.0D);
            this.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HIT, 1.0F, 1.0F);
        }
        else
        {
            boolean flag = result.entityHit.attackEntityFrom(DamageSource.causeIndirectDamage(this, this.owner).setProjectile(), 4.0F);

            if (flag)
            {
                int hrt = result.entityHit.hurtResistantTime;
                result.entityHit.hurtResistantTime = 0;
                result.entityHit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.owner).setProjectile().setDamageBypassesArmor(), magicDamage);
                result.entityHit.hurtResistantTime = hrt;
                this.applyEnchantments(this.owner, result.entityHit);

                if (result.entityHit instanceof EntityLivingBase)
                {
                    ((EntityLivingBase)result.entityHit).addPotionEffect(new PotionEffect(MobEffects.LEVITATION, potTime, potLevel));
                }
            }
        }

        this.setDead();
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, DiamondShulker.class, NAME, id,
                BadderBaddies.instance, 64, 3, true);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMyShulkerBullet.class, new IRenderFactory<EntityMyShulkerBullet>() {
            @Override
            public Render<? super EntityMyShulkerBullet> createRenderFor(RenderManager manager) {
                return new RenderShulkerBullet(manager);
            }
        });
    }
}
