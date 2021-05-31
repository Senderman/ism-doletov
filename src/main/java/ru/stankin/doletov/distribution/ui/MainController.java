package ru.stankin.doletov.distribution.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import ru.stankin.doletov.distribution.distribution.DistributionGenerator;
import ru.stankin.doletov.distribution.distribution.erlang.Erlang;
import ru.stankin.doletov.distribution.distribution.even.LemerMethod;
import ru.stankin.doletov.distribution.distribution.even.NativeRandom;
import ru.stankin.doletov.distribution.distribution.even.SimpleCongruenceMethod;
import ru.stankin.doletov.distribution.distribution.exp.Exp;
import ru.stankin.doletov.distribution.distribution.exp.HyperExp;
import ru.stankin.doletov.distribution.distribution.normal.Gauss;
import ru.stankin.doletov.distribution.distribution.normal.Muller;
import ru.stankin.doletov.distribution.distribution.simpson.TrapezoidDistribution;
import ru.stankin.doletov.distribution.distribution.simpson.TriangleMethod;

import java.io.IOException;

public class MainController {

    private void showBarChart(String windowName, DistributionGenerator generator) {
        try {
            var loader = new FXMLLoader(getClass().getResource("/barchart.fxml"));
            Parent barChartParent = loader.load();
            BarChartController barChartController = loader.getController();
            barChartController.setDistributionGenerator(generator);
            var scene = new Scene(barChartParent);
            var barChartStage = new Stage();
            barChartStage.setScene(scene);
            barChartStage.setTitle(windowName);
            barChartStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onNativeRandomButtonClick() {
        showBarChart("Встроенная случайность", new NativeRandom());
    }

    @FXML
    public void onScmButtonClick() {
        showBarChart("Метод простых конгруэнций", new SimpleCongruenceMethod());
    }

    @FXML
    public void onLemerButtonClick() {
        showBarChart("Метод Лемера", new LemerMethod());
    }

    @FXML
    public void onSimpsonTrapezoidButtonClick() {
        showBarChart("Трапецеидальный закон распределения", new TrapezoidDistribution());
    }

    @FXML
    public void onSimpsonTriangleMethodClick() {
        showBarChart("Треугольный закон распределения", new TriangleMethod());
    }

    @FXML
    public void onGaussButtonClick() {
        showBarChart("Распределение Гаусса", new Gauss());
    }

    @FXML
    public void onMullerButtonClick() {
        showBarChart("Распределение Мюллера", new Muller());
    }

    @FXML
    public void onExpButtonClick() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Лямбда");
        dialog.setHeaderText("Введите лямбду");
        dialog.setContentText("lambda: ");
        var result = dialog.showAndWait();
        result.map(Double::parseDouble)
                .ifPresent(l -> showBarChart("Гиперэкспоненциальное распределение", new Exp(l)));
    }

    @FXML
    public void onHyperExpButtonClick() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Лямбда");
        dialog.setHeaderText("Введите лямбду");
        dialog.setContentText("lambda: ");
        var result = dialog.showAndWait();
        result.map(Double::parseDouble)
                .ifPresent(l -> showBarChart("Гиперэкспоненциальное распределение", new HyperExp(l)));
    }

    @FXML
    public void onErlangButtonClick() {
        showBarChart("Распределение Эрланга", new Erlang());
    }

}
