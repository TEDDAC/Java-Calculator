import calculator.Context;
import calculator.Lexer;
import calculator.Parser;
import calculator.Token;
import calculator.nodes.Block;
import calculator.nodes.Node;
import calculator.nodes.NumberValue;
import io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.calc");
        IReader reader = new FileReader(file);
        IWriter writer = new StdWriter();

        Context globalContext = new Context();
        globalContext.setVariable("pi", new NumberValue(Math.PI));
        Block program = new Block(globalContext);

        String expression = reader.readLine().trim();
        while(!expression.isEmpty()){
            List<Token> tokens = Lexer.lexer(expression);
            Node node = Parser.parse(tokens, globalContext);
            program.addInstruction(node);
            expression = reader.readLine().trim();
        }

        program.interpret();
    }
}