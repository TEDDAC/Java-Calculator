package calculator.nodes;

import calculator.Context;

public class EqualOperator extends NodeOperator {
    public EqualOperator(Context context) {
        super(context);
    }

    @Override
    public Node interpret() {
        Node node = new NumberValue(((NumberValue)getRightParameter().interpret()).getValue());
        String name = ((Variable)getLeftParameter()).getIdentifier();
        this.getContext().setVariable(name, node);
        return new NullValue();
    }
}
