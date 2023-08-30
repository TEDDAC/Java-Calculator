package environnement.functions;

import calculator.Context;
import calculator.exceptions.NotAFunctionException;
import calculator.exceptions.NotInterpretableException;
import calculator.nodes.Block;
import calculator.nodes.Node;
import calculator.nodes.NumberValue;
import io.IWriter;

import java.util.List;

public class Print extends Block {
    IWriter writer;
    public Print(List<String> parameterNames, IWriter writer) {
        super(parameterNames);
        this.writer = writer;
    }

    public Print(IWriter writer){
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
