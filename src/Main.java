import calculator.Lexer;
import calculator.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String expression = "2 * 3";
        List<Token> tokens = Lexer.lexer(expression);
        System.out.println(tokens);
    }
}