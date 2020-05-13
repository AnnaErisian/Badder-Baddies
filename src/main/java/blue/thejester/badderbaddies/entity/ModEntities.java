package blue.thejester.badderbaddies.entity;

import blue.thejester.badderbaddies.entity.blaze.*;
import blue.thejester.badderbaddies.entity.cavespider.DashingCaveSpider;
import blue.thejester.badderbaddies.entity.cavespider.LeapingCaveSpider;
import blue.thejester.badderbaddies.entity.cavespider.TinyJerk;
import blue.thejester.badderbaddies.entity.ghast.*;
import blue.thejester.badderbaddies.entity.magmacube.ArgentCube;
import blue.thejester.badderbaddies.entity.magmacube.SolarCube;
import blue.thejester.badderbaddies.entity.shulker.AdamantiteShulker;
import blue.thejester.badderbaddies.entity.shulker.DiamondShulker;
import blue.thejester.badderbaddies.entity.shulker.EntityMyShulkerBullet;
import blue.thejester.badderbaddies.entity.shulker.IronShulker;
import blue.thejester.badderbaddies.entity.silverfish.Goldenfish;
import blue.thejester.badderbaddies.entity.silverfish.Platinumfish;
import blue.thejester.badderbaddies.entity.slime.BloodSlime;
import blue.thejester.badderbaddies.entity.slime.GelatinousCube;
import blue.thejester.badderbaddies.entity.slime.RockySlime;
import blue.thejester.badderbaddies.entity.slime.ShrapnelSlime;
import blue.thejester.badderbaddies.entity.spider.DashingSpider;
import blue.thejester.badderbaddies.entity.spider.LeapingSpider;
import blue.thejester.badderbaddies.entity.spider.MotherSpider;
import blue.thejester.badderbaddies.entity.spider.NeurovenomSpider;
import blue.thejester.badderbaddies.entity.vindicator.BrutalVindicator;
import blue.thejester.badderbaddies.entity.vindicator.RevenantVindicator;
import blue.thejester.badderbaddies.entity.witch.BattyWitch;
import blue.thejester.badderbaddies.entity.witch.CovenMatron;
import blue.thejester.badderbaddies.entity.witch.HighAlchemist;
import blue.thejester.badderbaddies.entity.witch.PreparedWitch;

public class ModEntities {
    public static void registerEntities() {
        int id = 1;

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
    }

    public static void registerRenderers() {
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
    }
}
