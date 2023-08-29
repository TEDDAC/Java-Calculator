package calculator;

import calculator.nodes.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Parser {
    public static Node parse(List<Token> tokens){
        List<Token> rpnToken = Parser.shuntingYard(tokens);
        Stack<Token> stack = new Stack<>();
        for (Token t : rpnToken){
            stack.push(t);
        }

        return Parser.createNode(stack);
    }

    /**
     * Convert infix notation into RPN.
     * @param tokens
     * @return
     */
    public static List<Token> shuntingYard(List<Token> tokens){
        List<Token> output = new LinkedList<>();
        Stack<Token> stack = new Stack<>();

        for(Token token : tokens){
            if(token.getType() == Token.Type.operator){
                while(!stack.isEmpty() && stack.peek().getType() == Token.Type.operator){
                    if(token.getPrecedence() <= stack.peek().getPrecedence()){
                        output.add(stack.pop());
                        continue;
                    }
                    break;
                }
                stack.push(token);
            } else if (token.getType() == Token.Type.parenthesis && token.getValue().equals("(")){
                stack.push(token);
            } else if (token.getType() == Token.Type.parenthesis && token.getValue().equals(")")){
                while (!stack.isEmpty() && !stack.peek().getValue().equals("(")){
                    output.add(stack.pop());
                }
                stack.pop();
            } else {
                output.add(token);
            }
        }

        while(!stack.isEmpty()){
            output.add(stack.pop());
        }

        return output;
    }

    public static Node createNode(Stack<Token> tokens){
        if(tokens.size() != 0){
            Token t = tokens.pop();
            if(t.getType() == Token.Type.operator){
                NodeOperator node;
                if(t.getValue().equals("-")){
                    node = new SubstractOperator();
                } else if(t.getValue().equals("*")){
                    node = new MultiplyOperator();
                } else if(t.getValue().equals("/")){
                    node = new DivideOperator();
                } else {
                    node = new AddOperator();
                }
                node.setRightParameter(Parser.createNode(tokens));
                node.setLeftParameter(Parser.createNode(tokens));
                return node;
            } else {
                return new NumberValue(Integer.parseInt(t.getValue()));
            }
        } else {
            return new NullValue();
        }
    }
}
