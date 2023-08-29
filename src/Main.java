import calculator.Lexer;
import calculator.Parser;
import calculator.Token;
import calculator.nodes.Node;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String expression = "2 * 38";
        List<Token> tokens = Lexer.lexer(expression);
        Node node = Parser.parse(tokens);

        expression = "2 + 3 * 4";
        tokens = Lexer.lexer(expression);
        node = Parser.parse(tokens);
        System.out.println(expression + " = " + node.interpret());

        expression = "2 * (3 + 4)";
        tokens = Lexer.lexer(expression);
        node = Parser.parse(tokens);
        System.out.println(expression + " = " + node.interpret());

        expression = "3 - 2";
        tokens = Lexer.lexer(expression);
        node = Parser.parse(tokens);
        System.out.println(expression + " = " + node.interpret());

        expression = "- 2";
        tokens = Lexer.lexer(expression);
        node = Parser.parse(tokens);
        System.out.println(expression + " = " + node.interpret());
    }
}