package calculator.nodes;

import calculator.Context;

public class AddOperator extends NodeOperator {
    public AddOperator(Context context){
        super(context);
    }

    @Override
    public Node interpret() {
        int leftResult = ((NumberValue)(getLeftParameter() != null ? getLeftParameter().interpret() : 0)).getValue();
        int rightResult = ((NumberValue)getRightParameter().interpret()).getValue();
        return new NumberValue(leftResult + rightResult);
    }
}
