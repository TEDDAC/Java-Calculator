package calculator.nodes;

import calculator.Context;

public class SubstractOperator extends NodeOperator {

    public SubstractOperator(Context context) {
        super(context);
    }

    @Override
    public Node interpret() {
        int leftResult = ((NumberValue)(getLeftParameter().interpret() != null ? getLeftParameter().interpret() : 0)).getValue();
        int rightResult = ((NumberValue)getRightParameter().interpret()).getValue();
        return new NumberValue(leftResult - rightResult);
    }
}
