package calculator.nodes;

import calculator.Context;

public class Identifier extends Node{
    private final String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Node interpret(Context context) {
        return context.getVariable(identifier);
    }
}
