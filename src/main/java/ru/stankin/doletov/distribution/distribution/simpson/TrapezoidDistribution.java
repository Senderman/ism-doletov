package ru.stankin.doletov.distribution.distribution.simpson;

import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class TrapezoidDistribution implements DistributionGenerator {

    @Override
    public double[] generate(int amount) {
        double[] result = new double[amount];
        var random = ThreadLocalRandom.current();
        for (int index = 0; index < amount; index++) {
            double firstNumber = random.nextDouble(1000, 100000);
            double secondNumber = random.nextDouble(500000, 1000000);
            double randTrapezoidal = Math.round(firstNumber + secondNumber);
            result[index] = randTrapezoidal;
        }
        return result;
    }

}
