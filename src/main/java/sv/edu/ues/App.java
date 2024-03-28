package sv.edu.ues;

import java.util.ArrayList;

import sv.edu.ues.implementations.GaussSeidelEj1;
import sv.edu.ues.implementations.GaussSeidelEj2;
import sv.edu.ues.implementations.JacobiEj1;
import sv.edu.ues.implementations.JacobiEj2;
import sv.edu.ues.view.ViewResult;

public class App {
    public static void main(String[] args) {
        Variable xVariable = new Variable("X");
        Variable yVariable = new Variable("Y");

        xVariable.setEquation("x = (6 + y) / 3");
        yVariable.setEquation("y = (8 + (2 * x)) / 4");

        JacobiEj1 jacobiEjercicio1 = new JacobiEj1();
        jacobiEjercicio1.calculate(xVariable, yVariable);

        ArrayList<Variable> listVariables = new ArrayList<>();
        listVariables.add(xVariable);
        listVariables.add(yVariable);
        ViewResult frame = new ViewResult(listVariables, "Ejercicio 3");
        frame.setVisible(true);
        frame.setLocation(100, 50);

        xVariable.setValues(new ArrayList<Double>());
        yVariable.setValues(new ArrayList<Double>());
        Variable zVariable = new Variable("Z");
        xVariable.setEquation("x = (10 - z + (2 * y)) / 4");
        yVariable.setEquation("y = (12 - (2 * x) - (2 * z)) / 3");
        zVariable.setEquation("z = (5 - x + y) / 4");

        JacobiEj2 jacobiEjercicio2 = new JacobiEj2();
        jacobiEjercicio2.calculate(xVariable, yVariable, zVariable);

        listVariables = new ArrayList<>();
        listVariables.add(xVariable);
        listVariables.add(yVariable);
        listVariables.add(zVariable);
        frame = new ViewResult(listVariables, "Ejercicio 4");
        frame.setVisible(true);
        frame.setLocation(650, 50);

        xVariable.setValues(new ArrayList<Double>());
        yVariable.setValues(new ArrayList<Double>());
        xVariable.setEquation("x = (7 + y) / 2");
        yVariable.setEquation("y = (2 + (3 * x)) / 4");

        GaussSeidelEj1 gaussSeidelEj1 = new GaussSeidelEj1();
        gaussSeidelEj1.calculate(xVariable, yVariable);
        listVariables = new ArrayList<>();
        listVariables.add(xVariable);
        listVariables.add(yVariable);

        frame = new ViewResult(listVariables, "Ejercicio 5");
        frame.setVisible(true);
        frame.setLocation(100, 525);

        xVariable.setValues(new ArrayList<Double>());
        yVariable.setValues(new ArrayList<Double>());
        zVariable.setValues(new ArrayList<Double>());
        xVariable.setEquation("x = (10 + y - z) / 3");
        yVariable.setEquation("y = (11 - x - (2 * z)) / 2");
        zVariable.setEquation("z = (5 - (2 * x) + (3 * y)) / 4");

        GaussSeidelEj2 gaussSeidelEj2 = new GaussSeidelEj2();
        gaussSeidelEj2.calculate(xVariable, yVariable, zVariable);

        listVariables = new ArrayList<>();
        listVariables.add(xVariable);
        listVariables.add(yVariable);
        listVariables.add(zVariable);

        frame = new ViewResult(listVariables, "Ejercicio 6");
        frame.setVisible(true);
        frame.setLocation(650, 525);
    }
}
