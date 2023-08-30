package calculator.nodes;

import calculator.Context;
import calculator.exceptions.NotAFunctionException;
import calculator.exceptions.NotInterpretableException;

public class Identifier extends Node{
    private final String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Node interpret(Context context) throws NotInterpretableException, NotAFunctionException {
        return context.getVariable(identifier);
    }
}
