package calculator.nodes;

import calculator.Context;

public class NumberValue extends Node {
    private double value;

    public NumberValue(Context context, double value){
        super(context);
        this.value = value;
    }

    public NumberValue(double value) {
        this(null, value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public Node interpret() {
        return this;
    }
}
