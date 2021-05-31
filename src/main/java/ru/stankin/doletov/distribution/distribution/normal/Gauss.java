package ru.stankin.doletov.distribution.distribution.normal;

import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Gauss implements DistributionGenerator {
    @Override
    public double[] generate(int amount) {
        double[] result = new double[amount];
        double n = 12; // константа, обычно 12
        var random = ThreadLocalRandom.current();

        for (int index = 0; index < amount; index++) {
            double mx = n / 2;
            double sigma = Math.sqrt(12 / n);
            result[index] = random.doubles()
                    .limit(amount)
                    .map(e -> (e - mx) * sigma)
                    .sum();
        }
        return result;
    }
}
