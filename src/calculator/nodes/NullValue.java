package calculator.nodes;

import calculator.Context;

public class NullValue extends Node {

    @Override
    public Node interpret(Context context) {
        return new NumberValue(0);
    }
}
