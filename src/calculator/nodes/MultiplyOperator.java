package calculator.nodes;

import calculator.Context;

public class MultiplyOperator extends NodeOperator {

    public MultiplyOperator(Context context) {
        super(context);
    }

    @Override
    public Node interpret() {
        double leftResult = ((NumberValue)(getLeftParameter().interpret())).getValue();
        double rightResult = ((NumberValue)getRightParameter().interpret()).getValue();
        return new NumberValue(leftResult * rightResult);
    }
}
