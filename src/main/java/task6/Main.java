package task6;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        XYChart chart = new XYChart(1000,1000);
        drawFirstFlow(chart);
        drawSecondFlow(chart);
        new SwingWrapper(chart).displayChart();
    }
    public static void drawFirstFlow(XYChart chart){
        List<Integer> firstFlowLengths = firstFlowLengths();
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        for (int i = 1; i < firstFlowLengths.stream().max(Integer::compareTo).orElse(0); i++) {
            X.add(i);
            int finalI = i;
            Y.add((int) firstFlowLengths.stream().filter(x->x== finalI).count());
        }
        chart.addSeries("first flow",X,Y);
    }
    public static void drawSecondFlow(XYChart chart){
        List<Integer> secondFlowLengths = secondFlowLengths();
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        for (int i = 1; i < secondFlowLengths.stream().max(Integer::compareTo).orElse(0); i++) {
            X.add(i);
            int finalI = i;
            Y.add((int) secondFlowLengths.stream().filter(x->x== finalI).count());
        }
        chart.addSeries("second flow",X,Y);
    }
    public static List<Integer> firstFlowLengths(){
        List<Integer> flow = getFlow(1000);
        List<Integer> lengths = new ArrayList<>();
        int currentLength = 1;
        for (int i = 0; i < 1000; i++) {
            if (flow.get(i) == 0){
                lengths.add(currentLength);
                currentLength=1;
                }
            else {
                currentLength++;
            }
        }
        return lengths;
    }
    public static List<Integer> secondFlowLengths(){
        List<Integer> flow = getFlow(1000);
        List<Integer> lengths = new ArrayList<>();
        int currentLength = 1;
        for (int i = 0; i < 1000; i++) {
            if (flow.get(i) == 1){
                lengths.add(currentLength);
                currentLength=1;
            }
            else {
                currentLength++;
            }
        }
        return lengths;
    }
    public static List<Integer> getFlow(int amount) {
        List<Integer> flow = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            if (random.nextInt(4)==0){
                flow.add(0);
            }
            else {
                flow.add(1);
            }
        }
        return flow;
    }
}
