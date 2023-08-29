package calculator.nodes;

import calculator.Context;

public class NullValue extends Node {
    public NullValue(Context context) {
        super(context);
    }

    public NullValue(){
        this(null);
    }

    @Override
    public Node interpret() {
        return new NumberValue(0);
    }
}
