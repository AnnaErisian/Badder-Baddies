package blue.thejester.badderbaddies.core;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.config.SpawnWeights;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
            EntityLiving newGuy = repset.getReplacement(oldGuy.getEntityWorld());
            if(newGuy != null) {
                newGuy.setLocationAndAngles(oldGuy.posX, oldGuy.posY, oldGuy.posZ, oldGuy.rotationYaw, oldGuy.rotationPitch);
                World world = oldGuy.getEntityWorld();
                newGuy.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(newGuy)), (IEntityLivingData)null);
                world.spawnEntity(newGuy);
                oldGuy.setDead();
            }
        }
    }
}
