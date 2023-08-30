package calculator.nodes;

import calculator.Context;

public class NumberValue extends Node {
    private double value;

    public NumberValue(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public Node interpret(Context context) {
        return this;
    }
}
