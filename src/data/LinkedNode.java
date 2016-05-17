package data;

public class LinkedNode<T> {

    private LinkedNode<T> nextNode;
    private T data;

    public LinkedNode(T data) {
        this.data = data;
    }

    public LinkedNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

}
