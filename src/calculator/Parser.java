package calculator;

import calculator.nodes.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Parser {
    public static Node parse(List<Token> tokens){
        Stack<Token> stack = new Stack<>();
        for (Token t : tokens){
            stack.push(t);
        }

        return Parser.createNode(stack);
    }

    public static Node createNode(Stack<Token> tokens){
        if(tokens.size() != 0){
            Token t = tokens.pop();
            if(t.getType() == Token.Type.operator){
                NodeOperator node = switch (t.getValue()) {
                    case "-" -> new SubstractOperator();
                    case "*" -> new MultiplyOperator();
                    case "/" -> new DivideOperator();
                    case "=" -> new EqualOperator();
                    default -> new AddOperator();
                };
                node.setRightParameter(Parser.createNode(tokens));
                node.setLeftParameter(Parser.createNode(tokens));
                return node;
            } else if (t.getType() == Token.Type.identifier) {
                return new Identifier(t.getValue());
            } /*else if(t.getType() == Token.Type.blockIdentifier) {
                Node params = Parser.createNode(tokens);
                return new FunctionCall();
            }*/ else {
                return new NumberValue(Integer.parseInt(t.getValue()));
            }
        } else {
            return new NullValue();
        }
    }
}
