package calculator.nodes;

public class SubstractOperator extends NodeOperator {

    @Override
    public int interpret() {
        return (getLeftParameter() != null ? getLeftParameter().interpret() : 0) - getRightParameter().interpret();
    }
}
