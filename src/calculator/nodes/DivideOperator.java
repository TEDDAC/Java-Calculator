package calculator.nodes;

public class DivideOperator extends NodeOperator {

    @Override
    public int interpret() {
        return getLeftParameter().interpret() / getRightParameter().interpret();
    }
}
