package blue.thejester.badderbaddies.entity;

import blue.thejester.badderbaddies.BadderBaddies;
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
import net.minecraft.util.ResourceLocation;

public class LootTables {

    public static final ResourceLocation BLAZE_MAGMA = create(MagmaBlaze.NAME);
    public static final ResourceLocation BLAZE_THUNDER = create(ThunderBlaze.NAME);
    public static final ResourceLocation BLAZE_WITHER = create(WitherBlaze.NAME);
    public static final ResourceLocation BLAZE_TURBO = create(TurboBlaze.NAME);

    public static final ResourceLocation CAVE_SPIDER_DASHING = create(DashingCaveSpider.NAME);
    public static final ResourceLocation CAVE_SPIDER_LEAPING = create(LeapingCaveSpider.NAME);
    public static final ResourceLocation CAVE_SPIDER_JERK = create(TinyJerk.NAME);

    public static final ResourceLocation CREEPER_ANGRY = create(AngryCreeper.NAME);
    public static final ResourceLocation CREEPER_SPEED = create(SpeedCreeper.NAME);
    public static final ResourceLocation CREEPER_WOBBLY = create(WobblyCreeper.NAME);
    public static final ResourceLocation CREEPER_QUANTUM = create(QuantumCreeper.NAME);

    public static final ResourceLocation ENDERMAN_BLENDERMAN = create(Blenderman.NAME);
    public static final ResourceLocation ENDERMAN_RENDERMAN = create(Renderman.NAME);
    public static final ResourceLocation ENDERMAN_SENDERMAN = create(Senderman.NAME);
    public static final ResourceLocation ENDERMAN_SLENDERMAN = create(Slenderman.NAME);

    public static final ResourceLocation GHAST_QUARTZ = create(QuartzGhast.NAME);
    public static final ResourceLocation GHAST_FATHER = create(FatherGhast.NAME);
    public static final ResourceLocation GHAST_ELDER = create(ElderGhast.NAME);
    public static final ResourceLocation GHAST_GOLDEN = create(GoldenGhast.NAME);

    public static final ResourceLocation HUSK_DESSICATED = create(DessicatedHusk.NAME);
    public static final ResourceLocation HUSK_MUMMY = create(Mummy.NAME);

    public static final ResourceLocation MAGMA_CUBE_ARGENT = create(ArgentCube.NAME);
    public static final ResourceLocation MAGMA_CUBE_SOLAR = create(SolarCube.NAME);

    public static final ResourceLocation SHULKER_IRON = create(IronShulker.NAME);
    public static final ResourceLocation SHULKER_DIAMOND = create(DiamondShulker.NAME);
    public static final ResourceLocation SHULKER_ADAMANTITE = create(AdamantiteShulker.NAME);

    public static final ResourceLocation SILVERFISH_GOLDENFISH = create(Goldenfish.NAME);
    public static final ResourceLocation SILVERFISH_PLATINUMFISH = create(Platinumfish.NAME);

    public static final ResourceLocation SKELETON_SWIFTARM = create(SwiftarmSkeleton.NAME);
    public static final ResourceLocation SKELETON_PHASING = create(PhasingSkeleton.NAME);
    public static final ResourceLocation SKELETON_BARRAGE = create(BarrageSkeleton.NAME);
    public static final ResourceLocation SKELETON_SALVO = create(SalvoSkeleton.NAME);

    public static final ResourceLocation SLIME_ROCKY = create(RockySlime.NAME);
    public static final ResourceLocation SLIME_BLOOD = create(BloodSlime.NAME);
    public static final ResourceLocation SLIME_SHRAPNEL = create(ShrapnelSlime.NAME);
    public static final ResourceLocation SLIME_GELATINOUS = create(GelatinousCube.NAME);

    public static final ResourceLocation SPIDER_DASHING = create(DashingSpider.NAME);
    public static final ResourceLocation SPIDER_MOTHER = create(MotherSpider.NAME);
    public static final ResourceLocation SPIDER_LEAPING = create(LeapingSpider.NAME);
    public static final ResourceLocation SPIDER_NEUROVENOM = create(NeurovenomSpider.NAME);

    public static final ResourceLocation STRAY_STRONGARM = create(StrongarmStray.NAME);
    public static final ResourceLocation STRAY_SLIMING = create(SlimingStray.NAME);
    public static final ResourceLocation STRAY_WANDERER = create(WandererStray.NAME);

    public static final ResourceLocation VINDICATOR_BRUTAL = create(BrutalVindicator.NAME);
    public static final ResourceLocation VINDICATOR_REVENANT = create(RevenantVindicator.NAME);

    public static final ResourceLocation WITCH_PREPARED = create(PreparedWitch.NAME);
    public static final ResourceLocation WITCH_BATTY = create(BattyWitch.NAME);
    public static final ResourceLocation WITCH_ALCHEMIST = create(HighAlchemist.NAME);
    public static final ResourceLocation WITCH_MATRON = create(CovenMatron.NAME);

    public static final ResourceLocation WITHER_SKELETON_PIGLIN = create(WitherPiglin.NAME);
    public static final ResourceLocation WITHER_SKELETON_CHARRED = create(CharredWS.NAME);
    public static final ResourceLocation WITHER_SKELETON_PEARLESCENT = create(PearlescentWS.NAME);
    public static final ResourceLocation WITHER_SKELETON_DRAGONHEART = create(DragonheartWS.NAME);

    public static final ResourceLocation ZOMBIE_ROTTING = create(RottingZombie.NAME);
    public static final ResourceLocation ZOMBIE_REACHING = create(ReachingZombie.NAME);
    public static final ResourceLocation ZOMBIE_PLAGUE = create(PlagueZombie.NAME);
    public static final ResourceLocation ZOMBIE_MUTATED = create(MutatedZombie.NAME);

    private static ResourceLocation create(String name) {
        return new ResourceLocation(BadderBaddies.MODID, "entities/" + name);
    }
}
