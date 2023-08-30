package environnement;

import calculator.Context;
import calculator.nodes.NumberValue;

public class GlobalContext extends Context {
    public GlobalContext(){
        super();
        setVariable("pi", new NumberValue(Math.PI));
    }
}
