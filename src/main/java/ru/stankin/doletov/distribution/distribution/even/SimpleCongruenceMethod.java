package ru.stankin.doletov.distribution.distribution.even;

import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleCongruenceMethod implements DistributionGenerator {

    @Override
    public double[] generate(int amount) {
        double a = Integer.MAX_VALUE;
        double p = Math.pow(10, 16);
        double x = ThreadLocalRandom.current().nextDouble(0, Integer.MAX_VALUE); // первое значение
        double[] result = new double[amount];
        for (int i = 0; i < amount; i++) {
            double xi = (a * x) % p;
            x = xi;
            while (xi > 1) {
                xi /= 10;
            }
            result[i] = xi;
        }
        return result;
    }
}
