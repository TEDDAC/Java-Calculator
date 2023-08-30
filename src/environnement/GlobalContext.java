package environnement;

import calculator.Context;
import calculator.nodes.Block;
import calculator.nodes.NumberValue;
import environnement.functions.MathSquare;
import io.IReader;
import io.IWriter;
import io.StdReader;
import io.StdWriter;

import java.util.LinkedList;

public class GlobalContext extends Context {
    public GlobalContext(){
        super();
        setVariable("pi", new NumberValue(Math.PI));

        IWriter writer = new StdWriter();
        Block print = new MathSquare(writer);
        setVariable("print", print);
    }
}
