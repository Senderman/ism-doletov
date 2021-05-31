package ru.stankin.doletov.distribution.distribution.even;

import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class LemerMethod implements DistributionGenerator {

    @Override
    public double[] generate(int amount) {
        double[] result = new double[amount];
        int a = 16807;
        int m = Integer.MAX_VALUE;
        int q = 127773;
        int r = 2836;
        int seed = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
        for (int i = 0; i < amount; i++) {
            int hi = seed / q;
            int lo = seed % q;
            seed = (a * lo) - (r * hi);
            if (seed <= 0)
                seed += m;
            result[i] = seed * 1.0 / m;
        }
        return result;
    }
}
