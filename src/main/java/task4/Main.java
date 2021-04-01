package task4;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        drawPoints(50);
        drawPoints(100);
        drawPoints(1000);
    }

    public static void drawPoints(int amount){
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        Random rnd = new Random();
        List<Double> numbers = new ArrayList<>();
        List<Double> numbersWithOffset = new ArrayList<>();
        numbers.add(rnd.nextDouble());
        numbers.add(rnd.nextDouble());
        for (int i = 0; i < amount; i++) {
            double newNumber = rnd.nextDouble();
            numbers.add(newNumber);
            numbersWithOffset.add(newNumber);
        }
        numbers.remove(numbers.size()-1);
        numbers.remove(numbers.size()-1);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.addSeries("point",numbers,numbersWithOffset);

        new SwingWrapper(chart).displayChart();
    }
}
