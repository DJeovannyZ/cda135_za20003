package sv.edu.ues.methods;

import sv.edu.ues.Variable;

public interface GaussSeidel2x2 extends Jacobi2x2 {

    @Override
    default void calculate(Variable xVariable, Variable yVariable) {
        for (int i = 1; i <= maxIterations; i++) {
            addValueX(i-1, xVariable, yVariable);
            addValueY(i, yVariable, xVariable);
            if (xVariable.getValue(i) == xVariable.getValue(i-1)
                    && yVariable.getValue(i) == yVariable.getValue(i-1)) {
                xVariable.setConverge(true);
                yVariable.setConverge(true);
                break;
            }
        }
    }
}
