package sv.edu.ues.implementations;

import sv.edu.ues.methods.GaussSeidel2x2;

public class GaussSeidelEj1 implements GaussSeidel2x2 {

    @Override
    public double getResultX(double y) {
        double x;
        x = (7 + y) / 2;
        x = Math.floor(x * 100) / 100;
        return x;
    }

    @Override
    public double getResultY(double x) {
        double y;
        y = (2 + (3 * x)) / 4;
        y = Math.floor(y * 100) / 100;
        return y;
    }

}
