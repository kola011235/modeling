package task2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    double startX;
    double startY;
    double startT;
    double radius;
    double endT;
    double h;
    double a;
    double b;
    List<Double> X = new ArrayList<>();
    List<Double> Y = new ArrayList<>();
    public Calculator(double startX, double startY, double radius, double startT, double endT, double h, double a, double b) {
        this.startX = startX;
        this.startY = startY;
        this.startT = startT;
        this.radius = radius;
        this.endT = endT;
        this.h = h;
        this.a = a;
        this.b = b;
        X.add(startX);
        Y.add(startY);
        for (double i = startT; i <endT ; i+=h) {
            double x = X.get(X.size()-1);
            double y = Y.get(Y.size()-1);
            if (Math.abs(x)>radius || Math.abs(y)>radius) {
                break;
            }
            X.add(x+h*fx(x,a));
            Y.add(y+h*fy(y,a));
        }
    }

    double fx(double x, double a){
        return a*x*x;
    }

    double fy(double y, double b){
        return b*y;
    }
}
