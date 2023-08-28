package calculator.nodes;

public class NumberValue implements Node {
    private int value;

    public NumberValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}
