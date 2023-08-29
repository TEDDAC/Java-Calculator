package calculator.nodes;

public class NullValue implements Node{
    @Override
    public int interpret() {
        return 0;
    }
}
