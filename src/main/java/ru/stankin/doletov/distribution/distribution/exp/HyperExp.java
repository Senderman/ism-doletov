package ru.stankin.doletov.distribution.distribution.exp;

import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class HyperExp implements DistributionGenerator {

    private final double lambda;

    public HyperExp(double lambda) {
        this.lambda = lambda;
    }

    @Override
    public double[] generate(int amount) {
        double[] result = new double[amount];
        var random = ThreadLocalRandom.current();
        for (int i = 0; i < amount; i++) {
            result[i] = Math.pow(-Math.log(random.nextDouble()) / lambda, 2);
        }
        return result;
    }
}
