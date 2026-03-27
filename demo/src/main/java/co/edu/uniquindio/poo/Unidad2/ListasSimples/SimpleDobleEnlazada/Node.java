package co.edu.uniquindio.poo.Unidad2.ListasSimples.SimpleDobleEnlazada;

public class Node<T> {
    private Node<T> previousNode;
    private Node<T> nextNode;
    private T data;

    public Node(T data) {
        this.nextNode = null;
        this.previousNode = null;
        this.data = data;
    }

    public Node<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getdata() {
        return data;
    }

    public void setdata(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node [nextNode=" + nextNode + ", data=" + data + "]";
    }
}