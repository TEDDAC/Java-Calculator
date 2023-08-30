package calculator.nodes;

import calculator.Context;

public abstract class NodeOperator extends Node {
    private Node leftParameter;
    private Node rightParameter;

    public Node getLeftParameter() {
        return leftParameter;
    }

    public void setLeftParameter(Node leftParameter) {
        this.leftParameter = leftParameter;
    }

    public Node getRightParameter() {
        return rightParameter;
    }

    public void setRightParameter(Node rightParameter) {
        this.rightParameter = rightParameter;
    }
}
