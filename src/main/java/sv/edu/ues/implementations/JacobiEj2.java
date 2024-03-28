package sv.edu.ues.implementations;

import sv.edu.ues.methods.Jacobi3x3;

public class JacobiEj2 implements Jacobi3x3 {

    public double getResultX(double y, double z) {
        double x;
        x = (10 - z + (2 * y)) / 4;
        x = Math.floor(x * 100) / 100;
        return x;
    }

    public double getResultY(double x, double z) {
        double y;
        y = (12 - (2 * x) - (2 * z)) / 3;
        y = Math.floor(y * 100) / 100;
        return y;
    }

    public double getResultZ(double x, double y) {
        double z;
        z = (5 - x + y) / 4;
        z = Math.floor(z * 100) / 100;
        return z;
    }


}
