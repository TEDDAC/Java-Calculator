package environnement;

import calculator.Context;
import calculator.nodes.Block;
import calculator.nodes.NumberValue;
import environnement.functions.Print;
import io.IWriter;
import io.StdWriter;

public class GlobalContext extends Context {
    public GlobalContext(){
        super();
        setVariable("pi", new NumberValue(Math.PI));

        IWriter writer = new StdWriter();
        Block print = new Print(writer);
        setVariable("print", print);
    }
}
