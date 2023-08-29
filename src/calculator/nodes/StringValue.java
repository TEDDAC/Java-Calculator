package calculator.nodes;

import calculator.Context;

public class StringValue extends Node{
    private String value;

    public StringValue(Context context, String value) {
        super(context);
        this.value = value;
    }

    public StringValue(String value){
        this(null, value);
    }

    @Override
    public Node interpret() {
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
