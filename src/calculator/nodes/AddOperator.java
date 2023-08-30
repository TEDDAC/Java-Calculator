package calculator.nodes;

import calculator.Context;

public class AddOperator extends NodeOperator {

    @Override
    public Node interpret(Context context) {
        double leftResult = ((NumberValue)(getLeftParameter() != null ? getLeftParameter().interpret(context) : 0)).getValue();
        double rightResult = ((NumberValue)getRightParameter().interpret(context)).getValue();
        return new NumberValue(leftResult + rightResult);
    }
}
