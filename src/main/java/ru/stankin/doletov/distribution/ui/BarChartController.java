package ru.stankin.doletov.distribution.ui;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import ru.stankin.doletov.distribution.distribution.DistributionGenerator;

import java.util.Arrays;

public class BarChartController {

    @FXML
    public BarChart<String, Number> barChart;
    @FXML
    public TextField amountOfElements;
    @FXML
    public TextField amountOfIntervals;

    private DistributionGenerator distributionGenerator;

    @FXML
    public void fillBarChart() {
        barChart.getData().clear();
        var series = new XYChart.Series<String, Number>();
        series.setName("Значения");
        int amount = Integer.parseInt(amountOfElements.getText());
        var input = distributionGenerator.generate(amount);
        Arrays.sort(input);
        final int intervalAmount = Integer.parseInt(amountOfIntervals.getText());
        final double max = input[input.length - 1];
        final double min = input[0];
        final double step = (max - min) / intervalAmount;
        for (double i = min; i + step < max; i += step) {
            int count = countInInterval(i, i + step, input);
            series.getData().add(new XYChart.Data<>(String.format("%.2f", i), count));
        }
        barChart.getData().add(series);
    }

    private int countInInterval(final double start, final double end, double[] data) {
        return (int) Arrays.stream(data)
                .dropWhile(e -> e < start)
                .filter(e -> e >= start && e < end)
                .count();
    }

    public void setDistributionGenerator(DistributionGenerator distributionGenerator) {
        this.distributionGenerator = distributionGenerator;
    }
}
