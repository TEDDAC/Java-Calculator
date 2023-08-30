package environnement.functions;

import calculator.Context;
import calculator.exceptions.NotAFunctionException;
import calculator.exceptions.NotInterpretableException;
import calculator.nodes.Block;
import calculator.nodes.Node;
import calculator.nodes.NullValue;
import calculator.nodes.NumberValue;
import io.IReader;
import io.IWriter;

import java.util.List;

public class MathSquare extends Block {
    IWriter writer;
    public MathSquare(List<String> parameterNames, IWriter writer) {
        super(parameterNames);
        this.writer = writer;
    }

    public MathSquare(IWriter writer){
        this(null, writer);
        addParameterName("message");
    }

    @Override
    public Node interpret(Context context) throws NotInterpretableException, NotAFunctionException {
        Node message = context.getVariable("message");
        writer.writeLine(String.valueOf(((NumberValue)message.interpret(context)).getValue()));
        return null;
    }
}
