package ru.stankin.doletov.distribution.distribution.even;

import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class NativeRandom implements DistributionGenerator {


    @Override
    public double[] generate(int amount) {
        double[] result = new double[amount];
        for (int i = 0; i < result.length; i++) {
            result[i] = ThreadLocalRandom.current().nextDouble(0, 1);
        }
        return result;
    }
}
