import calculator.Lexer;
import calculator.Parser;
import calculator.Token;
import calculator.nodes.Node;
import io.IReader;
import io.IWriter;
import io.StdReader;
import io.StdWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IReader reader = new StdReader();
        IWriter writer = new StdWriter();

        String expression = reader.readLine().trim();
        while(!expression.equals("exit")){
            List<Token> tokens = Lexer.lexer(expression);
            Node node = Parser.parse(tokens);
            writer.writeLine(String.valueOf(node.interpret()));
            expression = reader.readLine().trim();
        }
    }
}