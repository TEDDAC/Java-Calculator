package calculator.nodes;

import calculator.Context;

public class NumberValue extends Node {
    private int value;

    public NumberValue(Context context, int value){
        super(context);
        this.value = value;
    }

    public NumberValue(int value) {
        this(null, value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Node interpret() {
        return this;
    }
}
