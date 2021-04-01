package task2;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import task1.BarrelWithAHoleCalculator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        XYChart chart = new XYChart(1000,1000);
        for (int i=-2;i<=2;i++)
            for (int j = -2; j <= 2; j++) {
                draw(i,j,chart);
            }
        new SwingWrapper(chart).displayChart();
        System.in.read();
    }
    static void draw(int x,int y, XYChart chart) {
        Calculator calculator = new Calculator(x,y,10,0,1,0.001,1,1);
        chart.addSeries(x+" "+y,calculator.X, calculator.Y);

    }
}
