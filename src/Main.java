import calculator.Context;
import calculator.Lexer;
import calculator.Parser;
import calculator.Token;
import calculator.exceptions.NotAFunctionException;
import calculator.exceptions.NotInterpretableException;
import calculator.nodes.Block;
import calculator.nodes.Node;
import calculator.nodes.NumberValue;
import environnement.GlobalContext;
import io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, NotInterpretableException, NotAFunctionException {
        File file = new File("test.calc");
        IReader reader = new FileReader(file);
        IWriter writer = new StdWriter();

        Context globalContext = new GlobalContext();
        Block program = new Block(null);

        String expression = reader.readLine().trim();
        while(!expression.isEmpty()){
            List<Token> tokens = Lexer.lexer(expression);
            Node node = Parser.parse(tokens);
            program.addInstruction(node);
            expression = reader.readLine().trim();
        }

        program.interpret(globalContext);
    }
}