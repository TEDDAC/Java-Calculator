package calculator.nodes;

import calculator.Context;

public class DivideOperator extends NodeOperator {

    public DivideOperator(Context context) {
        super(context);
    }

    @Override
    public Node interpret() {
        int leftResult = ((NumberValue)(getLeftParameter().interpret())).getValue();
        int rightResult = ((NumberValue)getRightParameter().interpret()).getValue();
        return new NumberValue(leftResult / rightResult);
    }
}
