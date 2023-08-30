package calculator.nodes;

import calculator.Context;
import calculator.exceptions.NotAFunctionException;
import calculator.exceptions.NotInterpretableException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionCall extends Identifier {
    private final List<Node> paramNodes = new ArrayList<>();

    public FunctionCall(String identifier, List<Node> paramNodes){
        super(identifier);
        if(paramNodes != null){
            this.paramNodes.addAll(paramNodes);
        }
    }

    public FunctionCall(String identifier){
        this(identifier, null);
    }

    @Override
    public Node interpret(Context context) throws NotInterpretableException, NotAFunctionException {
        Node node = super.interpret(context);
        if(!(node instanceof Block block)){
            throw new NotAFunctionException(getIdentifier() + " is not a function.");
        }

        Context local = new Context(context);
        List<String> parameterNames = block.getParameterNames();
        for(int i = 0; i < parameterNames.size(); i++){
            local.setVariable(parameterNames.get(i), paramNodes.get(i));
        }

        return node.interpret(local);
    }


}
