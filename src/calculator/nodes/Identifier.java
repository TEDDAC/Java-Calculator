package calculator.nodes;

import calculator.Context;

public class Identifier extends Node{
    private final String identifier;

    public Identifier(Context context, String identifier) {
        super(context);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Node interpret() {
        return getContext().getVariable(identifier);
    }
}
