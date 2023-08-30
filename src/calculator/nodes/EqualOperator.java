package calculator.nodes;

import calculator.Context;
import calculator.exceptions.NotAFunctionException;
import calculator.exceptions.NotInterpretableException;

public class EqualOperator extends NodeOperator {

    @Override
    public Node interpret(Context context) throws NotInterpretableException, NotAFunctionException {
        Node node = new NumberValue(((NumberValue)getRightParameter().interpret(context)).getValue());
        String name = ((Identifier)getLeftParameter()).getIdentifier();
        context.setVariable(name, node);
        return node;
    }
}
