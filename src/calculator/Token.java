package calculator;

public class Token {
    private String value;
    private Type type;

    public Token(String value, Type type){
        this.value = value;
        this.type = type;
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

    enum Type {
        number,
        operator,
        parenthesis
    }

    @Override
    public String toString() {
        return type.toString() + ": " + value;
    }
}
