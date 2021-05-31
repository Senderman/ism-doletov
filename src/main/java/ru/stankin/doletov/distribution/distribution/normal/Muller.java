package ru.stankin.doletov.distribution.distribution.normal;

import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Muller implements DistributionGenerator {

    @Override
    public double[] generate(int amount) {
        double[] result = new double[amount];
        var random = ThreadLocalRandom.current();

        for (int index = 0; index < amount; index++) {
            double firstNumber = random.nextDouble(0, 1); // два случайных числа от0 до 1
            double secondNumber = random.nextDouble(0, 1);
            result[index] = Math.sqrt(-2 * Math.log(firstNumber)) * Math.sin(2 * Math.PI * secondNumber);
        }
        return result;
    }
}
