package calculator.nodes;

import calculator.Context;

public abstract class Node {
    private Context context;

    public Node(Context context){
        this.context = context;
    }
    public abstract Node interpret();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
