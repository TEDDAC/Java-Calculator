package calculator.nodes;

import calculator.Context;

public class SubstractOperator extends NodeOperator {

    @Override
    public Node interpret(Context context) {
        double leftResult = ((NumberValue)(getLeftParameter().interpret(context) != null ? getLeftParameter().interpret(context) : 0)).getValue();
        double rightResult = ((NumberValue)getRightParameter().interpret(context)).getValue();
        return new NumberValue(leftResult - rightResult);
    }
}
