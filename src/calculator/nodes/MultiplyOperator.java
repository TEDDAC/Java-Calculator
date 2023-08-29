package calculator.nodes;

public class MultiplyOperator extends NodeOperator {

    @Override
    public int interpret() {
        return getLeftParameter().interpret() * getRightParameter().interpret();
    }
}
