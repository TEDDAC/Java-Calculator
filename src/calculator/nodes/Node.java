package calculator.nodes;

import calculator.Context;

public abstract class Node {
    public abstract Node interpret(Context context);
}
