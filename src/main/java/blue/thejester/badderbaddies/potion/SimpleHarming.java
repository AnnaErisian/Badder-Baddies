package blue.thejester.badderbaddies.potion;

import blue.thejester.badderbaddies.BadderBaddies;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = BadderBaddies.MODID)
public class SimpleHarming extends Potion {
    public static final SimpleHarming potion = new SimpleHarming(true, 0x430A09);

    protected SimpleHarming(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
        setRegistryName(BadderBaddies.MODID, "simple_harming");
    }

    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {
        if (!entityLivingBaseIn.isEntityUndead())
        {
            entityLivingBaseIn.hurtResistantTime = 0;
            entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, amplifier);
        } else {
            entityLivingBaseIn.heal(amplifier);
        }
    }

    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, EntityLivingBase entityLivingBaseIn, int amplifier, double health)
    {
        if (!entityLivingBaseIn.isEntityUndead())
        {
            if (source == null)
            {
                entityLivingBaseIn.hurtResistantTime = 0;
                entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, amplifier);
            }
            else
            {
                entityLivingBaseIn.hurtResistantTime = 0;
                entityLivingBaseIn.attackEntityFrom(DamageSource.causeIndirectMagicDamage(source, indirectSource), amplifier);
            }
        } else {
            entityLivingBaseIn.heal(amplifier);
        }
    }

    /**
     * Returns true if the potion has an instant effect instead of a continuous one (eg Harming)
     */
    public boolean isInstant()
    {
        return true;
    }

    /**
     * checks if Potion effect is ready to be applied this tick.
     */
    public boolean isReady(int duration, int amplifier)
    {
        return duration >= 1;
    }

    @SubscribeEvent
    public static void registerPotion(RegistryEvent.Register<Potion> event) {;
        event.getRegistry().register(potion);
    }

}
