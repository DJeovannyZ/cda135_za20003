package sv.edu.ues.implementations;

import sv.edu.ues.methods.GaussSeidel3x3;

public class GaussSeidelEj2 implements GaussSeidel3x3 {

    @Override
    public double getResultX(double y, double z) {
        double x;
        x = (10 + y - z) / 3;
        x = Math.floor(x * 100) / 100;
        return x;
    }

    @Override
    public double getResultY(double x, double z) {
        double y;
        y = (11 - x - (2 * z)) / 2;
        y = Math.floor(y * 100) / 100;
        return y;
    }

    @Override
    public double getResultZ(double x, double y) {
        double z;
        z = (5 - (2 * x) + (3 * y)) / 4;
        z = Math.floor(z * 100) / 100;
        return z;
    }
}
