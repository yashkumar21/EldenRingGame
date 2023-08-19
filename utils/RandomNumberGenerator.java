package game.utils;

import java.util.Random;

/**
 * A random number generator
 * Created by: FIT2099 Teaching team
 * @author Adrian Kristanto
 * Modified by: N/A
 *
 */
public class RandomNumberGenerator {
    public static int getRandomInt(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : 0;
    }

    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return new Random().nextInt(range) + lowerBound;
    }
}
