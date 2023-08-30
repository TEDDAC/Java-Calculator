package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Lexer {
    public static List<Token> lexer(String expression){
        List<Token> tokens = new LinkedList<>();

        expression = expression.trim();
        expression = expression.replaceAll(" ", "");
        List<Character> expressionList = new LinkedList<>();
        for(char c : expression.toCharArray()){
            expressionList.add(c);
        }

        StringBuilder stringBuilder;
        while(expressionList.size() > 0){
            char c = expressionList.get(0);
            switch(c){
                case '+':
                case '-':
                case '=':
                    tokens.add(new Token(String.valueOf(c), Token.Type.operator, 0));
                    expressionList.remove(0);
                    break;
                case '*':
                case '/':
                    tokens.add(new Token(String.valueOf(c), Token.Type.operator, 5));
                    expressionList.remove(0);
                    break;
                case '(':
                case ')':
                    tokens.add(new Token(String.valueOf(c), Token.Type.parenthesis, 0));
                    expressionList.remove(0);
                    break;
                case ',':
                    expressionList.remove(0);
                    break;
                default:
                    stringBuilder = new StringBuilder();
                    while(Character.isDigit(c) || Character.isAlphabetic(c)){
                        stringBuilder.append(c);
                        expressionList.remove(0);
                        if(expressionList.size() == 0) {
                            break;
                        }
                        c = expressionList.get(0);
                    }
                    String s = stringBuilder.toString();
                    if(s.matches("^[0-9]$")){
                        tokens.add(new Token(stringBuilder.toString(), Token.Type.number, 0));
                    } else {
                        tokens.add(new Token(stringBuilder.toString(), Token.Type.identifier, 0));
                    }

                    break;
            }
        }

        return Lexer.shuntingYard(tokens);
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
}
