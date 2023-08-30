package calculator;

public class Token {
    private String value;
    private Type type;
    private int precedence;

    public Token(String value, Type type, int precedence){
        this.value = value;
        this.type = type;
        this.precedence = precedence;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    enum Type {
        number,
        operator,
        parenthesis,
        identifier,
        blockIdentifier
    }

    @Override
    public String toString() {
        return type.toString() + ": " + value;
    }
}
