package sv.edu.ues;

public class Util {

    public static void printVariable(Variable variable) {
        System.out.println("Valores de " + variable.getName());
        System.out.print("[ ");
        for (int i = 1; i < variable.getValues().size(); i++) {
            System.out.print("I" + i + ": " + variable.getValue(i));
            if (i != variable.getValues().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]\n");
        System.out.println(variable.getName() + " converge a " + variable.getValue(variable.getValues().size() - 1));

    }
}
