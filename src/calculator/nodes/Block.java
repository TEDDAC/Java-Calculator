package calculator.nodes;

import calculator.Context;
import calculator.exceptions.NotAFunctionException;
import calculator.exceptions.NotInterpretableException;
import io.IWriter;
import io.StdWriter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Block extends Node {
    private final List<Node> instructions = new LinkedList<>();

    private final List<String> parameterNames = new ArrayList<>();

    public Block(List<String> parameterNames){
        if(parameterNames != null) {
            this.parameterNames.addAll(parameterNames);
        }
    }

    public void addInstruction(Node node){
        instructions.add(node);
    }

    public void addParameterName(String paramName){
        this.parameterNames.add(paramName);
    }

    @Override
    public Node interpret(Context context) throws NotInterpretableException, NotAFunctionException {
        IWriter writer = new StdWriter();
        for(Node node : instructions){
            Node result = node.interpret(context);
        }
        return null;
    }

    public List<String> getParameterNames() {
        return parameterNames;
    }
}
