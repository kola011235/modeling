package task1;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BarrelWithAHoleCalculator barrel = new BarrelWithAHoleCalculator(0.6,0.1,4,6,0.1,1);
        System.out.println("t = "+ barrel.Ts.get(barrel.Ts.size()-1));
        XYChart chart = QuickChart.getChart("chart", "t", "x", "x(t)",
                barrel.Ts, barrel.Xs);
        new SwingWrapper(chart).displayChart();
        System.in.read();
    }
}
