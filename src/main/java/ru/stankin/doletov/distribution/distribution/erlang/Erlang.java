package ru.stankin.doletov.distribution.distribution.erlang;

import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Erlang implements DistributionGenerator {

    @Override
    public double[] generate(int amount) { // amount = k
        double[] result = new double[amount];
        var random = ThreadLocalRandom.current();
        for (int i = 0; i < amount; i++) {
            double x = 0;
            double eps = random.nextDouble(0, 1);
            for (int j = 0; j < (double) amount; j++) {
                double z = -1 * Math.log(eps);
                x += z;
            }
            result[i] = x;
        }
        return result;
    }
}
