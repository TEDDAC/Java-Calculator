package calculator.nodes;

import calculator.Context;
import io.IWriter;
import io.StdWriter;

import java.util.LinkedList;
import java.util.List;

public class Block extends Node {
    private final List<Node> instructions = new LinkedList<>();

    public Block(Context context) {
        super(context);
    }

    public void addInstruction(Node node){
        instructions.add(node);
    }

    @Override
    public Node interpret() {
        IWriter writer = new StdWriter();
        for(Node node : instructions){
            Node result = node.interpret();
            writer.writeLine(String.valueOf(((NumberValue)result.interpret()).getValue()));
        }
        return null;
    }
}
