package calculator.nodes;

import calculator.Context;
import calculator.exceptions.NotAFunctionException;
import calculator.exceptions.NotInterpretableException;

public abstract class Node {
    public abstract Node interpret(Context context) throws NotInterpretableException, NotAFunctionException;
}
