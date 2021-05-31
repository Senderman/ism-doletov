package ru.stankin.doletov.distribution.distribution.simpson;

import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class TriangleMethod implements DistributionGenerator {

    @Override
    public double[] generate(int amount) {
        double[] result = new double[amount];
        var random = ThreadLocalRandom.current();
        for (int index = 0; index < amount; index++) {
            double firstNumber = random.nextDouble(20000, 60000);
            double secondNumber = random.nextDouble(20000, 60000);
            double randTrapezoidal = Math.round(firstNumber + secondNumber);
            result[index] = randTrapezoidal;
        }
        return result;
    }
}
