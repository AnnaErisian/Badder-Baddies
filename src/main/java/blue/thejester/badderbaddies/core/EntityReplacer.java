package blue.thejester.badderbaddies.core;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.config.SpawnWeights;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = BadderBaddies.MODID)
public class EntityReplacer {

    /* NOTES
    Slimes go through this BEFORE their internal checks
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onEntitySpawn(LivingSpawnEvent.SpecialSpawn event) {
        ReplacementSet repset = ReplacementSet.replacementSets.get(event.getEntityLiving().getClass());
        if(repset != null) {
            EntityLivingBase oldGuy = event.getEntityLiving();
            EntityLivingBase newGuy = repset.getReplacement(oldGuy.getEntityWorld());
            if(newGuy != null) {
                newGuy.setLocationAndAngles(oldGuy.posX, oldGuy.posY, oldGuy.posZ, oldGuy.rotationYaw, oldGuy.rotationPitch);
                oldGuy.getEntityWorld().spawnEntity(newGuy);
                oldGuy.setDead();
            }
        }
    }
}
