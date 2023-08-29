package calculator;

import java.util.LinkedList;
import java.util.List;

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
                default:
                    stringBuilder = new StringBuilder();
                    while(Character.isDigit(c)){
                        stringBuilder.append(c);
                        expressionList.remove(0);
                        if(expressionList.size() == 0) {
                            break;
                        }
                        c = expressionList.get(0);
                    }
                    tokens.add(new Token(stringBuilder.toString(), Token.Type.number, 0));
                    break;
            }
        }

        return tokens;
    }
}
