package blue.thejester.badderbaddies.potion;

import blue.thejester.badderbaddies.BadderBaddies;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class SimpleHarming extends Potion {
    public static SimpleHarming potion;

    protected SimpleHarming(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
    }

    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {
        if (!entityLivingBaseIn.isEntityUndead())
        {
            if (!entityLivingBaseIn.isEntityUndead())
            {
                entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, amplifier);
            }
        }
        else
        {
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
    public static void register(RegistryEvent.Register<Potion> event) {
        potion = new SimpleHarming(true, 0x430A09);
        potion.setRegistryName(BadderBaddies.MODID, "simple_harming");
        event.getRegistry().register(potion);
    }

}
