package calculator.nodes;

import calculator.Context;

public class MultiplyOperator extends NodeOperator {

    @Override
    public Node interpret(Context context) {
        double leftResult = ((NumberValue)(getLeftParameter().interpret(context))).getValue();
        double rightResult = ((NumberValue)getRightParameter().interpret(context)).getValue();
        return new NumberValue(leftResult * rightResult);
    }
}
