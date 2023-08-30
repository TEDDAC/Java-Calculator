package environnement;

import calculator.Context;
import calculator.nodes.NumberValue;

public class GlobalContext extends Context {
    public GlobalContext(){
        setVariable("pi", new NumberValue(Math.PI));
    }
}
