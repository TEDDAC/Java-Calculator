package calculator.nodes;

import calculator.Context;

public class StringValue extends Node{
    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public Node interpret(Context context) {
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
