package hexlet.code;

import java.util.Random;

public final class Util {
    private static final Random RANDOM = new Random();
    public static final int DEFAULT_RANGE = 101;

    public static int getRandomNumber(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int getRandomNumber(int origin, int bound) {
        return RANDOM.nextInt(origin, bound);
    }

    public static int getRandomNumber() {
        return getRandomNumber(DEFAULT_RANGE);
    }
}
