package sv.edu.ues.implementations;

import sv.edu.ues.methods.Jacobi2x2;

public class JacobiEj1 implements Jacobi2x2 {

    public double getResultX(double y) {
        double x;
        x = (6 + y) / 3;
        x = Math.floor(x * 100) / 100;
        return x;
    }

    public double getResultY(double x) {
        double y;
        y = (8 + (2 * x)) / 4;
        y = Math.floor(y * 100) / 100;
        return y;
    }
}
