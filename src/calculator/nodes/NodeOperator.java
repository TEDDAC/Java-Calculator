package calculator.nodes;

public abstract class NodeOperator implements Node {
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
