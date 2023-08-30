package calculator;

import calculator.nodes.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Parser {
    public static Node parse(List<Token> tokens, Context context){
        Stack<Token> stack = new Stack<>();
        for (Token t : tokens){
            stack.push(t);
        }

        return Parser.createNode(stack, context);
    }

    public static Node createNode(Stack<Token> tokens, Context context){
        if(tokens.size() != 0){
            Token t = tokens.pop();
            if(t.getType() == Token.Type.operator){
                NodeOperator node = switch (t.getValue()) {
                    case "-" -> new SubstractOperator(context);
                    case "*" -> new MultiplyOperator(context);
                    case "/" -> new DivideOperator(context);
                    case "=" -> new EqualOperator(context);
                    default -> new AddOperator(context);
                };
                node.setRightParameter(Parser.createNode(tokens, context));
                node.setLeftParameter(Parser.createNode(tokens, context));
                return node;
            } else if (t.getType() == Token.Type.identifier) {
                return new Identifier(context, t.getValue());
            } else {
                return new NumberValue(Integer.parseInt(t.getValue()));
            }
        } else {
            return new NullValue();
        }
    }
}
