package sv.edu.ues;

import java.util.ArrayList;

public class Variable {
    private String name, equation;
    private ArrayList<Double> values;
    private boolean converge;

    public Variable(String name) {
        this.name = name;
        this.values = new ArrayList<Double>();
        converge = false;
        addValue(0);
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addValue(double value) {
        this.values.add(value);
    }

    public double getValue(int position) {
        return this.values.get(position);
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    public void setValues(ArrayList<Double> values) {
        this.values = values;
        converge = false;
        addValue(0);
    }

    public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

	public boolean isConverge() {
		return converge;
	}

	public void setConverge(boolean converge) {
		this.converge = converge;
	}

	public double getLastValue(){
        return getValue(getValues().size()-1);
    }

}
