package calculator.nodes;

import calculator.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionCall extends Identifier {
    private final List<String> parameterNames = new ArrayList<>();

    public FunctionCall(String identifier, List<String> paramNames){
        super(identifier);
        parameterNames.addAll(paramNames);
    }

    public FunctionCall(String identifier){
        this(identifier, null);
    }

    public void addParameterNames(String name){
        parameterNames.add(name);
    }

    public List<String> getParameterNames() {
        return Collections.unmodifiableList(parameterNames);
    }

    @Override
    public Node interpret(Context context) {
        Node node = super.interpret(context);
        return node.interpret(context);
    }


}
