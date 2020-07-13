package blue.thejester.badderbaddies.core;

import blue.thejester.badderbaddies.config.SpawnWeights;
import blue.thejester.badderbaddies.entity.blaze.MagmaBlaze;
import blue.thejester.badderbaddies.entity.blaze.ThunderBlaze;
import blue.thejester.badderbaddies.entity.blaze.TurboBlaze;
import blue.thejester.badderbaddies.entity.blaze.WitherBlaze;
import blue.thejester.badderbaddies.entity.cavespider.DashingCaveSpider;
import blue.thejester.badderbaddies.entity.cavespider.LeapingCaveSpider;
import blue.thejester.badderbaddies.entity.cavespider.TinyJerk;
import blue.thejester.badderbaddies.entity.creeper.AngryCreeper;
import blue.thejester.badderbaddies.entity.creeper.QuantumCreeper;
import blue.thejester.badderbaddies.entity.creeper.SpeedCreeper;
import blue.thejester.badderbaddies.entity.creeper.WobblyCreeper;
import blue.thejester.badderbaddies.entity.enderman.Blenderman;
import blue.thejester.badderbaddies.entity.enderman.Renderman;
import blue.thejester.badderbaddies.entity.enderman.Senderman;
import blue.thejester.badderbaddies.entity.enderman.Slenderman;
import blue.thejester.badderbaddies.entity.ghast.ElderGhast;
import blue.thejester.badderbaddies.entity.ghast.FatherGhast;
import blue.thejester.badderbaddies.entity.ghast.GoldenGhast;
import blue.thejester.badderbaddies.entity.ghast.QuartzGhast;
import blue.thejester.badderbaddies.entity.husk.DessicatedHusk;
import blue.thejester.badderbaddies.entity.husk.Mummy;
import blue.thejester.badderbaddies.entity.magmacube.ArgentCube;
import blue.thejester.badderbaddies.entity.magmacube.SolarCube;
import blue.thejester.badderbaddies.entity.shulker.AdamantiteShulker;
import blue.thejester.badderbaddies.entity.shulker.DiamondShulker;
import blue.thejester.badderbaddies.entity.shulker.IronShulker;
import blue.thejester.badderbaddies.entity.silverfish.Goldenfish;
import blue.thejester.badderbaddies.entity.silverfish.Platinumfish;
import blue.thejester.badderbaddies.entity.skeleton.BarrageSkeleton;
import blue.thejester.badderbaddies.entity.skeleton.PhasingSkeleton;
import blue.thejester.badderbaddies.entity.skeleton.SalvoSkeleton;
import blue.thejester.badderbaddies.entity.skeleton.SwiftarmSkeleton;
import blue.thejester.badderbaddies.entity.slime.BloodSlime;
import blue.thejester.badderbaddies.entity.slime.GelatinousCube;
import blue.thejester.badderbaddies.entity.slime.RockySlime;
import blue.thejester.badderbaddies.entity.slime.ShrapnelSlime;
import blue.thejester.badderbaddies.entity.spider.DashingSpider;
import blue.thejester.badderbaddies.entity.spider.LeapingSpider;
import blue.thejester.badderbaddies.entity.spider.MotherSpider;
import blue.thejester.badderbaddies.entity.spider.NeurovenomSpider;
import blue.thejester.badderbaddies.entity.stray.SlimingStray;
import blue.thejester.badderbaddies.entity.stray.StrongarmStray;
import blue.thejester.badderbaddies.entity.stray.WandererStray;
import blue.thejester.badderbaddies.entity.vindicator.BrutalVindicator;
import blue.thejester.badderbaddies.entity.vindicator.RevenantVindicator;
import blue.thejester.badderbaddies.entity.witch.BattyWitch;
import blue.thejester.badderbaddies.entity.witch.CovenMatron;
import blue.thejester.badderbaddies.entity.witch.HighAlchemist;
import blue.thejester.badderbaddies.entity.witch.PreparedWitch;
import blue.thejester.badderbaddies.entity.witherskeleton.CharredWS;
import blue.thejester.badderbaddies.entity.witherskeleton.DragonheartWS;
import blue.thejester.badderbaddies.entity.witherskeleton.PearlescentWS;
import blue.thejester.badderbaddies.entity.witherskeleton.WitherPiglin;
import blue.thejester.badderbaddies.entity.zombie.MutatedZombie;
import blue.thejester.badderbaddies.entity.zombie.PlagueZombie;
import blue.thejester.badderbaddies.entity.zombie.ReachingZombie;
import blue.thejester.badderbaddies.entity.zombie.RottingZombie;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.*;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReplacementSet {

    static HashMap<Class<? extends EntityLiving>, ReplacementSet> replacementSets = new HashMap<>();

    private List<ReplacementEntry> entries;
    private int weightTotal = 0;

    private ReplacementSet(ReplacementEntry... e) {
        entries = Arrays.asList(e);
    }

    private int getWeightTotal() {
        if(weightTotal > 0) {
            return weightTotal;
        } else {
            weightTotal = 0;
            for(ReplacementEntry e : entries) {
                weightTotal += e.weight;
            }
            return weightTotal;
        }
    }

    public EntityLiving getReplacement(World world) {
        int rand = world.rand.nextInt(getWeightTotal());
        for(ReplacementEntry e : entries) {
            if(rand < e.weight) {
                return e.getEntity(world);
            } else {
                rand -= e.weight;
            }
        }
        return null;
    }

    static abstract class ReplacementEntry {

        public ReplacementEntry(int weight) {
            this.weight = weight;
        }

        int weight;

        /**
         * Either returns the new entity, or null to pass
         * @param w the World to spawn into
         * @return the new entity, or null to pass
         */
        public abstract EntityLiving getEntity(World w);
    }

    static {
        replacementSets.put(EntityZombie.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(1)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(1, w) ? new RottingZombie(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new ReachingZombie(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new PlagueZombie(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new MutatedZombie(w) : null; } }
        ));
        replacementSets.put(EntityHusk.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new DessicatedHusk(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(5)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(5, w) ? new Mummy(w) : null; } }
        ));
        replacementSets.put(EntityCreeper.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(1)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(1, w) ? new AngryCreeper(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new SpeedCreeper(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new WobblyCreeper(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new QuantumCreeper(w) : null; } }
        ));
        replacementSets.put(EntitySkeleton.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(1)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(1, w) ? new SwiftarmSkeleton(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new PhasingSkeleton(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new BarrageSkeleton(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new SalvoSkeleton(w) : null; } }
        ));
        replacementSets.put(EntityStray.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new StrongarmStray(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new SlimingStray(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(5)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(5, w) ? new WandererStray(w) : null; } }
        ));
        replacementSets.put(EntityWitherSkeleton.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new WitherPiglin(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new CharredWS(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new PearlescentWS(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(5)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(5, w) ? new DragonheartWS(w) : null; } }
        ));
        replacementSets.put(EntitySpider.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(1)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(1, w) ? new DashingSpider(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new MotherSpider(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new LeapingSpider(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new NeurovenomSpider(w) : null; } }
        ));
        replacementSets.put(EntityCaveSpider.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new DashingCaveSpider(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new LeapingCaveSpider(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(5)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(5, w) ? new TinyJerk(w) : null; } }
        ));
        replacementSets.put(EntityWitch.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new PreparedWitch(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new BattyWitch(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(5)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(5, w) ? new HighAlchemist(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(6)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(6, w) ? new CovenMatron(w) : null; } }
        ));
        replacementSets.put(EntityGhast.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new QuartzGhast(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new FatherGhast(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new ElderGhast(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(6)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(6, w) ? new GoldenGhast(w) : null; } }
        ));
        replacementSets.put(EntitySilverfish.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new Goldenfish(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(5)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(5, w) ? new Platinumfish(w) : null; } }
        ));
        replacementSets.put(EntityBlaze.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new MagmaBlaze(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new ThunderBlaze(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new WitherBlaze(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(6)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(6, w) ? new TurboBlaze(w) : null; } }
        ));
        replacementSets.put(EntityShulker.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new IronShulker(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new DiamondShulker(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(6)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(6, w) ? new AdamantiteShulker(w) : null; } }
        ));
        replacementSets.put(EntityVindicator.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new BrutalVindicator(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(5)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(5, w) ? new RevenantVindicator(w) : null; } }
        ));
        replacementSets.put(EntitySlime.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new RockySlime(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new BloodSlime(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(5)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(5, w) ? new ShrapnelSlime(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(6)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(6, w) ? new GelatinousCube(w) : null; } }
        ));
        replacementSets.put(EntityMagmaCube.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new SolarCube(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(5)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(5, w) ? new ArgentCube(w) : null; } }
        ));
        replacementSets.put(EntityEnderman.class, new ReplacementSet(
                new ReplacementEntry(SpawnWeights.getRelativeWeight(0)) { public EntityLiving getEntity(World w) { return null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(2)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(2, w) ? new Blenderman(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(3)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(3, w) ? new Slenderman(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(4)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(4, w) ? new Renderman(w) : null; } },
                new ReplacementEntry(SpawnWeights.getRelativeWeight(5)) { public EntityLiving getEntity(World w) { return SpawnWeights.canSpawnOnDay(5, w) ? new Senderman(w) : null; } }
        ));
    }
}
