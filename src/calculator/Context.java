package calculator;

import calculator.exceptions.MemberNotFoundException;
import calculator.nodes.Node;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Context {
    private final Map<String, Node> variables = new HashMap<>();


    public Context(Map<String, Node> variables) {
        setVariables(variables);
    }

    public Context(){

    }

    public Map<String, Node> getVariables(){
        return Collections.unmodifiableMap(variables);
    }

    public void setVariables(Map<String, Node> variables) {
        this.variables.putAll(variables);
    }

    public void setVariable(String name, Node value){
        this.variables.put(name, value);
    }

    public Node getVariable(String name){
        Node value = this.variables.get(name);
        if(value == null){
            throw new MemberNotFoundException("No member named '" + name + "' found in context");
        }
        return value;
    }
}
