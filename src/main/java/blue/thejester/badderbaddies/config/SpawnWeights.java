package blue.thejester.badderbaddies.config;

import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import static net.minecraft.world.EnumDifficulty.EASY;

public class SpawnWeights {
    private static int[] RELATIVE_WEIGHTS = {100, 90, 75, 60, 45, 30, 20};
    private static int[] EASY_SPAWN_DAYS = {0, 16, 24, 42, 60, 80, 100};
    private static int[] NORM_SPAWN_DAYS = {0, 8, 18, 30, 45, 60, 75};
    private static int[] HARD_SPAWN_DAYS = {0, 6, 14, 20, 30, 40, 50};
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
