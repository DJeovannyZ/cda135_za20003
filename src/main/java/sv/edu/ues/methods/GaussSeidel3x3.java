package sv.edu.ues.methods;

import sv.edu.ues.Variable;

public interface GaussSeidel3x3 extends Jacobi3x3 {
    @Override
    default void addValueY(int position, Variable yVariable, Variable xVariable, Variable zVariable) {
        yVariable.addValue(getResultY(xVariable.getValue(position), zVariable.getValue(position - 1)));
    }

    @Override
    default void calculate(Variable xVariable, Variable yVariable, Variable zVariable) {
        for (int i = 1; i <= maxIterations; i++) {
            addValueX(i - 1, xVariable, yVariable, zVariable);
            addValueY(i, yVariable, xVariable, zVariable);
            addValueZ(i, zVariable, xVariable, yVariable);
            if (xVariable.getValue(i) == xVariable.getValue(i-1)
                    && yVariable.getValue(i) == yVariable.getValue(i-1)
                    && zVariable.getValue(i) == zVariable.getValue(i-1)) {
                xVariable.setConverge(true);
                yVariable.setConverge(true);
                zVariable.setConverge(true);
                break;
            }
        }
    }
}
