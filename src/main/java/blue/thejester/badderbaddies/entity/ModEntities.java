package blue.thejester.badderbaddies.entity;

import blue.thejester.badderbaddies.config.SpawnWeights;
import blue.thejester.badderbaddies.entity.blaze.*;
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
import blue.thejester.badderbaddies.entity.ghast.*;
import blue.thejester.badderbaddies.entity.husk.DessicatedHusk;
import blue.thejester.badderbaddies.entity.husk.Mummy;
import blue.thejester.badderbaddies.entity.magmacube.ArgentCube;
import blue.thejester.badderbaddies.entity.magmacube.SolarCube;
import blue.thejester.badderbaddies.entity.shulker.AdamantiteShulker;
import blue.thejester.badderbaddies.entity.shulker.DiamondShulker;
import blue.thejester.badderbaddies.entity.shulker.EntityMyShulkerBullet;
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModEntities {
    public static void registerEntities() {
        int id = 1;

        RottingZombie.registerSelf(id++);
        ReachingZombie.registerSelf(id++);
        PlagueZombie.registerSelf(id++);
        MutatedZombie.registerSelf(id++);

        DessicatedHusk.registerSelf(id++);
        Mummy.registerSelf(id++);

        AngryCreeper.registerSelf(id++);
        SpeedCreeper.registerSelf(id++);
        WobblyCreeper.registerSelf(id++);
        QuantumCreeper.registerSelf(id++);

        SwiftarmSkeleton.registerSelf(id++);
        PhasingSkeleton.registerSelf(id++);
        BarrageSkeleton.registerSelf(id++);
        SalvoSkeleton.registerSelf(id++);

        StrongarmStray.registerSelf(id++);
        SlimingStray.registerSelf(id++);
        WandererStray.registerSelf(id++);

        WitherPiglin.registerSelf(id++);
        CharredWS.registerSelf(id++);
        PearlescentWS.registerSelf(id++);
        DragonheartWS.registerSelf(id++);

        DashingSpider.registerSelf(id++);
        MotherSpider.registerSelf(id++);
        LeapingSpider.registerSelf(id++);
        NeurovenomSpider.registerSelf(id++);

        DashingCaveSpider.registerSelf(id++);
        LeapingCaveSpider.registerSelf(id++);
        TinyJerk.registerSelf(id++);

        PreparedWitch.registerSelf(id++);
        BattyWitch.registerSelf(id++);
        HighAlchemist.registerSelf(id++);
        CovenMatron.registerSelf(id++);

        EntityCreeperFireball.registerSelf(id++);
        EntitySuperCreeperFireball.registerSelf(id++);
        QuartzGhast.registerSelf(id++);
        FatherGhast.registerSelf(id++);
        ElderGhast.registerSelf(id++);
        GoldenGhast.registerSelf(id++);

        Goldenfish.registerSelf(id++);
        Platinumfish.registerSelf(id++);

        LightningFireball.registerSelf(id++);
        WitherFireball.registerSelf(id++);
        WitherFireballStacking.registerSelf(id++);
        MagmaBlaze.registerSelf(id++);
        ThunderBlaze.registerSelf(id++);
        WitherBlaze.registerSelf(id++);
        TurboBlaze.registerSelf(id++);

        EntityMyShulkerBullet.registerSelf(id++);
        IronShulker.registerSelf(id++);
        DiamondShulker.registerSelf(id++);
        AdamantiteShulker.registerSelf(id++);

        BrutalVindicator.registerSelf(id++);
        RevenantVindicator.registerSelf(id++);

        RockySlime.registerSelf(id++);
        BloodSlime.registerSelf(id++);
        ShrapnelSlime.registerSelf(id++);
        GelatinousCube.registerSelf(id++);

        SolarCube.registerSelf(id++);
        ArgentCube.registerSelf(id++);

        Blenderman.registerSelf(id++);
        Slenderman.registerSelf(id++);
        Renderman.registerSelf(id++);
        Senderman.registerSelf(id++);
    }

    public static void registerRenderers() {

        RottingZombie.registerOwnRenderer();
        ReachingZombie.registerOwnRenderer();
        PlagueZombie.registerOwnRenderer();
        MutatedZombie.registerOwnRenderer();

        DessicatedHusk.registerOwnRenderer();
        Mummy.registerOwnRenderer();

        AngryCreeper.registerOwnRenderer();
        SpeedCreeper.registerOwnRenderer();
        WobblyCreeper.registerOwnRenderer();
        QuantumCreeper.registerOwnRenderer();

        SwiftarmSkeleton.registerOwnRenderer();
        PhasingSkeleton.registerOwnRenderer();
        BarrageSkeleton.registerOwnRenderer();
        SalvoSkeleton.registerOwnRenderer();

        StrongarmStray.registerOwnRenderer();
        SlimingStray.registerOwnRenderer();
        WandererStray.registerOwnRenderer();

        WitherPiglin.registerOwnRenderer();
        CharredWS.registerOwnRenderer();
        PearlescentWS.registerOwnRenderer();
        DragonheartWS.registerOwnRenderer();

        DashingSpider.registerOwnRenderer();
        MotherSpider.registerOwnRenderer();
        LeapingSpider.registerOwnRenderer();
        NeurovenomSpider.registerOwnRenderer();

        DashingCaveSpider.registerOwnRenderer();
        LeapingCaveSpider.registerOwnRenderer();
        TinyJerk.registerOwnRenderer();

        PreparedWitch.registerOwnRenderer();
        BattyWitch.registerOwnRenderer();
        HighAlchemist.registerOwnRenderer();
        CovenMatron.registerOwnRenderer();

        EntityCreeperFireball.registerOwnRenderer();
        EntitySuperCreeperFireball.registerOwnRenderer();
        QuartzGhast.registerOwnRenderer();
        FatherGhast.registerOwnRenderer();
        ElderGhast.registerOwnRenderer();
        GoldenGhast.registerOwnRenderer();

        Goldenfish.registerOwnRenderer();
        Platinumfish.registerOwnRenderer();

        LightningFireball.registerOwnRenderer();
        WitherFireball.registerOwnRenderer();
        WitherFireballStacking.registerOwnRenderer();
        MagmaBlaze.registerOwnRenderer();
        ThunderBlaze.registerOwnRenderer();
        WitherBlaze.registerOwnRenderer();
        TurboBlaze.registerOwnRenderer();

        EntityMyShulkerBullet.registerOwnRenderer();
        IronShulker.registerOwnRenderer();
        DiamondShulker.registerOwnRenderer();
        AdamantiteShulker.registerOwnRenderer();

        BrutalVindicator.registerOwnRenderer();
        RevenantVindicator.registerOwnRenderer();

        RockySlime.registerOwnRenderer();
        BloodSlime.registerOwnRenderer();
        ShrapnelSlime.registerOwnRenderer();
        GelatinousCube.registerOwnRenderer();

        SolarCube.registerOwnRenderer();
        ArgentCube.registerOwnRenderer();

        Blenderman.registerOwnRenderer();
        Slenderman.registerOwnRenderer();
        Renderman.registerOwnRenderer();
        Senderman.registerOwnRenderer();
    }

    public static void registerLootTables() {
        LootTableList.register(LootTables.BLAZE_MAGMA);
        LootTableList.register(LootTables.BLAZE_THUNDER);
        LootTableList.register(LootTables.BLAZE_WITHER);
        LootTableList.register(LootTables.BLAZE_TURBO);

        LootTableList.register(LootTables.CAVE_SPIDER_DASHING);
        LootTableList.register(LootTables.CAVE_SPIDER_LEAPING);
        LootTableList.register(LootTables.CAVE_SPIDER_JERK);

        LootTableList.register(LootTables.CREEPER_ANGRY);
        LootTableList.register(LootTables.CREEPER_SPEED);
        LootTableList.register(LootTables.CREEPER_WOBBLY);
        LootTableList.register(LootTables.CREEPER_QUANTUM);

        LootTableList.register(LootTables.ENDERMAN_BLENDERMAN);
        LootTableList.register(LootTables.ENDERMAN_RENDERMAN);
        LootTableList.register(LootTables.ENDERMAN_SENDERMAN);
        LootTableList.register(LootTables.ENDERMAN_SLENDERMAN);

        LootTableList.register(LootTables.GHAST_QUARTZ);
        LootTableList.register(LootTables.GHAST_FATHER);
        LootTableList.register(LootTables.GHAST_ELDER);
        LootTableList.register(LootTables.GHAST_GOLDEN);

        LootTableList.register(LootTables.HUSK_DESSICATED);
        LootTableList.register(LootTables.HUSK_MUMMY);

        LootTableList.register(LootTables.MAGMA_CUBE_ARGENT);
        LootTableList.register(LootTables.MAGMA_CUBE_SOLAR);

        LootTableList.register(LootTables.SHULKER_IRON);
        LootTableList.register(LootTables.SHULKER_DIAMOND);
        LootTableList.register(LootTables.SHULKER_ADAMANTITE);

        LootTableList.register(LootTables.SILVERFISH_GOLDENFISH);
        LootTableList.register(LootTables.SILVERFISH_PLATINUMFISH);

        LootTableList.register(LootTables.SKELETON_SWIFTARM);
        LootTableList.register(LootTables.SKELETON_PHASING);
        LootTableList.register(LootTables.SKELETON_BARRAGE);
        LootTableList.register(LootTables.SKELETON_SALVO);

        LootTableList.register(LootTables.SLIME_ROCKY);
        LootTableList.register(LootTables.SLIME_BLOOD);
        LootTableList.register(LootTables.SLIME_SHRAPNEL);
        LootTableList.register(LootTables.SLIME_GELATINOUS);

        LootTableList.register(LootTables.SPIDER_DASHING);
        LootTableList.register(LootTables.SPIDER_MOTHER);
        LootTableList.register(LootTables.SPIDER_LEAPING);
        LootTableList.register(LootTables.SPIDER_NEUROVENOM);

        LootTableList.register(LootTables.STRAY_STRONGARM);
        LootTableList.register(LootTables.STRAY_SLIMING);
        LootTableList.register(LootTables.STRAY_WANDERER);

        LootTableList.register(LootTables.VINDICATOR_BRUTAL);
        LootTableList.register(LootTables.VINDICATOR_REVENANT);

        LootTableList.register(LootTables.WITCH_PREPARED);
        LootTableList.register(LootTables.WITCH_BATTY);
        LootTableList.register(LootTables.WITCH_ALCHEMIST);
        LootTableList.register(LootTables.WITCH_MATRON);

        LootTableList.register(LootTables.WITHER_SKELETON_PIGLIN);
        LootTableList.register(LootTables.WITHER_SKELETON_CHARRED);
        LootTableList.register(LootTables.WITHER_SKELETON_PEARLESCENT);
        LootTableList.register(LootTables.WITHER_SKELETON_DRAGONHEART);

        LootTableList.register(LootTables.ZOMBIE_ROTTING);
        LootTableList.register(LootTables.ZOMBIE_REACHING);
        LootTableList.register(LootTables.ZOMBIE_PLAGUE);
        LootTableList.register(LootTables.ZOMBIE_MUTATED);
    }
}
