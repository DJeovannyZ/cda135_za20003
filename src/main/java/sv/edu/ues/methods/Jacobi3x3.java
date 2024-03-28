package sv.edu.ues.methods;

import sv.edu.ues.Variable;

public interface Jacobi3x3 {
    final int maxIterations = 20;

    double getResultX(double y, double z);

    double getResultY(double x, double z);

    double getResultZ(double x, double y);

    default void addValueX(int position, Variable xVariable, Variable yVariable, Variable zVariable) {
        xVariable.addValue(getResultX(yVariable.getValue(position), zVariable.getValue(position)));
    }

    default void addValueY(int position, Variable yVariable, Variable xVariable, Variable zVariable) {
        yVariable.addValue(getResultY(xVariable.getValue(position), zVariable.getValue(position)));
    }

    default void addValueZ(int position, Variable zVariable, Variable xVariable, Variable yVariable) {
        zVariable.addValue(getResultZ(xVariable.getValue(position), yVariable.getValue(position)));
    }

    default void calculate(Variable xVariable, Variable yVariable, Variable zVariable) {
        for (int i = 0; i < maxIterations; i++) {
            addValueX(i, xVariable, yVariable, zVariable);
            addValueY(i, yVariable, xVariable, zVariable);
            addValueZ(i, zVariable, xVariable, yVariable);
            if (xVariable.getValue(i + 1) == xVariable.getValue(i)
                    && yVariable.getValue(i + 1) == yVariable.getValue(i)
                    && zVariable.getValue(i + 1) == zVariable.getValue(i)) {
                xVariable.setConverge(true);
                yVariable.setConverge(true);
                zVariable.setConverge(true);
                break;
            }
        }
    }
}
