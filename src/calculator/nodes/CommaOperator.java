package calculator.nodes;

import calculator.Context;
import calculator.exceptions.NotInterpretableException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CommaOperator extends NodeOperator{
    public List<Node> getParams(){
        List<Node> params = new ArrayList<>();
        if(getLeftParameter() instanceof CommaOperator){
            params.addAll(((CommaOperator) getLeftParameter()).getParams());
        } else {
            params.add(getLeftParameter());
        }

        if(getRightParameter() instanceof CommaOperator){
            params.addAll(((CommaOperator) getRightParameter()).getParams());
        } else {
            params.add(getLeftParameter());
        }

        return params;
    }

    @Override
    public Node interpret(Context context) throws NotInterpretableException {
        throw new NotInterpretableException("This node is not interpretable.");
    }
}
