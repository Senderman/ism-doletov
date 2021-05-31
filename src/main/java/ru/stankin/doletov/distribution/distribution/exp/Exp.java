package ru.stankin.doletov.distribution.distribution.exp;

import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Exp implements DistributionGenerator {

    private final double lamdba;

    public Exp(double lamdba) {
        this.lamdba = lamdba;
    }

    @Override
    public double[] generate(int amount) {
        double[] result = new double[amount];
        var random = ThreadLocalRandom.current();
        for (int i = 0; i < amount; i++) {
            double x = random.nextDouble(0, 1); // начальная случайная величина
            result[i] = (-1 / lamdba) * Math.log(x);
        }
        return result;
    }
}
