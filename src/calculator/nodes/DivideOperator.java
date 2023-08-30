package calculator.nodes;

import calculator.Context;
import calculator.exceptions.NotAFunctionException;
import calculator.exceptions.NotInterpretableException;

public class DivideOperator extends NodeOperator {

    @Override
    public Node interpret(Context context) throws NotInterpretableException, NotAFunctionException {
        double leftResult = ((NumberValue)(getLeftParameter().interpret(context))).getValue();
        double rightResult = ((NumberValue)getRightParameter().interpret(context)).getValue();
        return new NumberValue(leftResult / rightResult);
    }
}
