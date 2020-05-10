package blue.thejester.badderbaddies.entity;

import blue.thejester.badderbaddies.entity.magmacube.ArgentCube;
import blue.thejester.badderbaddies.entity.magmacube.SolarCube;
import blue.thejester.badderbaddies.entity.slime.BloodSlime;
import blue.thejester.badderbaddies.entity.slime.GelatinousCube;
import blue.thejester.badderbaddies.entity.slime.RockySlime;
import blue.thejester.badderbaddies.entity.slime.ShrapnelSlime;
import blue.thejester.badderbaddies.entity.vindicator.BrutalVindicator;
import blue.thejester.badderbaddies.entity.vindicator.RevenantVindicator;

public class ModEntities {
    public static void registerEntities() {
        int id = 1;
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
