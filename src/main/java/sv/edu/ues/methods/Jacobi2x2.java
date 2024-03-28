package sv.edu.ues.methods;

import sv.edu.ues.Variable;

public interface Jacobi2x2 {
    final int maxIterations = 20;

    double getResultX(double y);

    double getResultY(double x);

    default void addValueX(int position, Variable xVariable, Variable yVariable) {
        xVariable.addValue(getResultX(yVariable.getValue(position)));
    }

    default void addValueY(int position, Variable yVariable, Variable xVariable) {
        yVariable.addValue(getResultY(xVariable.getValue(position)));
    }

    default void calculate(Variable xVariable, Variable yVariable) {
        for (int i = 0; i < maxIterations; i++) {
            addValueX(i, xVariable, yVariable);
            addValueY(i, yVariable, xVariable);
            if (xVariable.getValue(i + 1) == xVariable.getValue(i)
                    && yVariable.getValue(i + 1) == yVariable.getValue(i)) {
                xVariable.setConverge(true);
                yVariable.setConverge(true);
                break;
            }
        }
    }
}
