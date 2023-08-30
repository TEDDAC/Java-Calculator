package calculator.nodes;

import calculator.Context;

public class EqualOperator extends NodeOperator {

    @Override
    public Node interpret(Context context) {
        Node node = new NumberValue(((NumberValue)getRightParameter().interpret(context)).getValue());
        String name = ((Identifier)getLeftParameter()).getIdentifier();
        context.setVariable(name, node);
        return node;
    }
}
