package blue.thejester.badderbaddies.config;

import blue.thejester.badderbaddies.BadderBaddies;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import static net.minecraft.world.EnumDifficulty.EASY;

@net.minecraftforge.common.config.Config(modid= BadderBaddies.MODID)
public class SpawnWeights {
    @net.minecraftforge.common.config.Config.Comment({"Relative weight of mobs by tier - tier 0 is vanilla versions - default 100,70,50,35,30,25,20"})
    public static int[] RELATIVE_WEIGHTS = {100, 70, 50, 35, 30, 25, 20};
    @net.minecraftforge.common.config.Config.Comment({"Number of days after which each tier can spawn in easy mode - default 0,16,24,42,60,80,100"})
    public static int[] EASY_SPAWN_DAYS = {0, 16, 24, 42, 60, 80, 100};
    @net.minecraftforge.common.config.Config.Comment({"Number of days after which each tier can spawn in normal mode - default 0,8,18,30,45,60,75"})
    public static int[] NORM_SPAWN_DAYS = {0, 8, 18, 30, 45, 60, 75};
    @net.minecraftforge.common.config.Config.Comment({"Number of days after which each tier can spawn in hard mode - default 0,6,14,20,30,40,50"})
    public static int[] HARD_SPAWN_DAYS = {0, 6, 14, 20, 30, 40, 50};

    public static int getRelativeWeight(int tier) {
        return RELATIVE_WEIGHTS[tier];
    }
    public static boolean canSpawnOnDay(int tier, World world) {
        long day = world.getTotalWorldTime() / 24000;

        switch (world.getDifficulty()) {
            case EASY:
                return day >= EASY_SPAWN_DAYS[tier];
            case NORMAL:
                return day >= NORM_SPAWN_DAYS[tier];
            case HARD:
                return day >= HARD_SPAWN_DAYS[tier];
            default:
                return true;
        }
    }
}
