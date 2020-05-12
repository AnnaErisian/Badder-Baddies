package blue.thejester.badderbaddies.entity.witch;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class EntityMyWitch extends EntityWitch {

    private static final UUID MODIFIER_UUID = UUID.fromString("70ee5ecc-0702-410a-8a04-f6861da75290");
    private static final AttributeModifier MODIFIER = (new AttributeModifier(MODIFIER_UUID, "Drinking speed penalty", -0.25D, 0)).setSaved(false);
    private int potionUseTimer;

    public EntityMyWitch(World worldIn) {
        super(worldIn);
    }

    protected abstract int getAbsorptionLevel();
    protected abstract float getSpeedMult();
    protected abstract int getResistanceLevel();
    protected abstract boolean hasFireResistance();
    protected abstract int thrownPotionLevel();
    protected abstract int healingPotionLevel();

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        IEntityLivingData data = super.onInitialSpawn(difficulty, livingdata);
        if(getAbsorptionLevel() > 0) {
            addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, Integer.MAX_VALUE, getAbsorptionLevel()));
        }
        if(getResistanceLevel() > 0) {
            addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, Integer.MAX_VALUE, getResistanceLevel()));
        }
        if(hasFireResistance()) {
            addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, Integer.MAX_VALUE));
        }
        return data;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D * getSpeedMult());
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (!this.world.isRemote)
        {
            if (this.isDrinkingPotion())
            {
                if (this.potionUseTimer-- <= 0)
                {
                    this.setDrinkingPotion(false);
                    ItemStack itemstack = this.getHeldItemMainhand();
                    this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);

                    if (itemstack.getItem() == Items.POTIONITEM)
                    {
                        List<PotionEffect> list = PotionUtils.getEffectsFromStack(itemstack);

                        if (list != null)
                        {
                            for (PotionEffect potioneffect : list)
                            {
                                this.addPotionEffect(new PotionEffect(potioneffect));
                            }
                        }
                    }

                    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(MODIFIER);
                }
            }
            else
            {
                PotionType potiontype = null;

                if (this.rand.nextFloat() < 0.15F && this.isInsideOfMaterial(Material.WATER) && !this.isPotionActive(MobEffects.WATER_BREATHING))
                {
                    potiontype = PotionTypes.WATER_BREATHING;
                }
                else if (this.rand.nextFloat() < 0.15F && (this.isBurning() || this.getLastDamageSource() != null && this.getLastDamageSource().isFireDamage()) && !this.isPotionActive(MobEffects.FIRE_RESISTANCE))
                {
                    potiontype = PotionTypes.FIRE_RESISTANCE;
                }
                else if (this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth())
                {
                    potiontype = PotionTypes.HEALING;
                }
                else if (this.rand.nextFloat() < 0.5F && this.getAttackTarget() != null && !this.isPotionActive(MobEffects.SPEED) && this.getAttackTarget().getDistanceSq(this) > 121.0D)
                {
                    potiontype = PotionTypes.SWIFTNESS;
                }

                if (potiontype != null)
                {
                    this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, getPotionItem(potiontype));
                    this.potionUseTimer = this.getHeldItemMainhand().getMaxItemUseDuration();
                    this.setDrinkingPotion(true);
                    this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_WITCH_DRINK, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
                    IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
                    iattributeinstance.removeModifier(MODIFIER);
                    iattributeinstance.applyModifier(MODIFIER);
                }
            }

            if (this.rand.nextFloat() < 7.5E-4F)
            {
                this.world.setEntityState(this, (byte)15);
            }
        }

        super.onLivingUpdate();
    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor)
    {
        if (!this.isDrinkingPotion())
        {
            double d0 = target.posY + (double)target.getEyeHeight() - 1.100000023841858D;
            double d1 = target.posX + target.motionX - this.posX;
            double d2 = d0 - this.posY;
            double d3 = target.posZ + target.motionZ - this.posZ;
            float f = MathHelper.sqrt(d1 * d1 + d3 * d3);
            PotionType potiontype = PotionTypes.HARMING;

            if (f >= 8.0F && !target.isPotionActive(MobEffects.SLOWNESS))
            {
                potiontype = PotionTypes.SLOWNESS;
            }
            else if (target.getHealth() >= 8.0F && !target.isPotionActive(MobEffects.POISON))
            {
                potiontype = PotionTypes.POISON;
            }
            else if (f <= 3.0F && !target.isPotionActive(MobEffects.WEAKNESS) && this.rand.nextFloat() < 0.25F)
            {
                potiontype = PotionTypes.WEAKNESS;
            }

            EntityPotion entitypotion = new EntityPotion(this.world, this, getPotionItem(potiontype));
            entitypotion.rotationPitch -= -20.0F;
            entitypotion.shoot(d1, d2 + (double)(f * 0.2F), d3, 0.75F, 8.0F);
            this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_WITCH_THROW, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
            this.world.spawnEntity(entitypotion);
        }
    }

    protected ItemStack getPotionItem(PotionType potiontype) {
        if(potiontype == PotionTypes.HEALING) {
            return getHealingPotionItem(healingPotionLevel());
        } else if(potiontype == PotionTypes.SLOWNESS) {
            return getPotionItem(MobEffects.SLOWNESS, 1800, thrownPotionLevel());
        } else if(potiontype == PotionTypes.WEAKNESS) {
            return getPotionItem(MobEffects.WEAKNESS, 1800, thrownPotionLevel());
        } else if(potiontype == PotionTypes.POISON) {
            return getPotionItem(MobEffects.POISON, 900, thrownPotionLevel());
        } else if(potiontype == PotionTypes.HARMING) {
            return getPotionItem(MobEffects.INSTANT_DAMAGE, 1, thrownPotionLevel());
        } else {
            return PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potiontype);
        }
    }

    private ItemStack getPotionItem(Potion p, int dur, int lvl) {
        return PotionUtils.appendEffects(
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), PotionTypes.WATER),
                Arrays.asList(new PotionEffect[]{new PotionEffect(p, dur, lvl)})
        );
    }

    private ItemStack getHealingPotionItem(int lvl) {
        return PotionUtils.appendEffects(
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.HEALING),
                Arrays.asList(new PotionEffect[]{new PotionEffect(MobEffects.INSTANT_HEALTH, 1, lvl-1)})
        );
    }
}
