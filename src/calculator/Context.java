package calculator;

import calculator.exceptions.MemberNotFoundException;
import calculator.nodes.Node;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Context {
    private final Map<String, Node> variables;

    private final Context parent;

    public Context(Context parent, Map<String, Node> variables) {
        this.parent = parent;
        this.variables = new HashMap<>();
        setVariables(variables);
    }

    public Context(Map<String, Node> variables){
        this(null, variables);
    }

    public Context(){
        this(null, null);
    }

    public Map<String, Node> getVariables(){
        return Collections.unmodifiableMap(variables);
    }

    public void setVariables(Map<String, Node> variables) {
        if(variables != null) {
            this.variables.putAll(variables);
        }
    }

    public void setVariable(String name, Node value){
        this.variables.put(name, value);
    }

    public Node getVariable(String name){
        Node value = this.variables.get(name);
        if(parent != null){
            return parent.getVariable(name);
        } else if(value == null){
            throw new MemberNotFoundException("No member named '" + name + "' found in context");
        }
        return value;
    }
}
