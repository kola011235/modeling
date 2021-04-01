package task1;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class BarrelWithAHoleCalculator {
    double k;
    double s;
    double S;
    double g = 9.8;
    double finalX;
    double h;

    List<Double> Xs = new ArrayList<Double>();
    List<Double> Ts = new ArrayList<Double>();
    public BarrelWithAHoleCalculator(double k, double r, double D, double x0, double finalX, double h) {
        this.k = k;
        s = getS(r);
        S = getS(D/2);
        this.finalX = finalX;
        this.h = h;
        Xs.add(x0);
        Ts.add(0.0);
        while (Xs.get(Xs.size()-1)>finalX) {
            Ts.add(Ts.get(Ts.size()-1)+h);
            Xs.add(Xs.get(Xs.size()-1)+h*fd(Xs.get(Xs.size()-1)));
        }
    }

    double getS (double radius) {
        return Math.PI*radius*radius;
    }

    double fd(double x) {
        return - k*s*Math.sqrt(2*g*x)/S;
    }

    double getTime(){
        return Ts.get(Ts.size()-1);
    }
}
