package task5;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double suitable = 0;
        for (int i = 0; i < 1000; i++) {
            if (getCylinderInsideDiameter()>getKernelDiameter())
                suitable++;
        }
        System.out.println("suitable - "+(suitable/1000)*100+" percent");
    }
    public static double getKernelDiameter() {
        return normalDistribution(0.99,0.01);
    }
    public static double getCylinderInsideDiameter() {
        return normalDistribution(1,0.01);
    }
    public static double normalDistribution(double mathematicalExpectation,double standardDeviation){
        Random random = new Random();
        double sum = 0;
        for (int i = 0; i<12;i++){
            sum+=random.nextDouble();
        }
        sum-=6;
        return mathematicalExpectation+sum;
    }

}
