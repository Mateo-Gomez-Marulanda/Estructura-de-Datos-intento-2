package co.edu.uniquindio.poo.Unidad2.Simple.SimpleEnlazada.Base;

public class Main {
    public static void main(String[] args) {
        ListaSimple<Integer> integers = new ListaSimple<>();

        System.out.println(integers.isEmpty());
        integers.addFirst(2);
        integers.addFirst(3);
        integers.addFirst(5);
        integers.addFirst(7);
        integers.addFirst(11);
        integers.printList();

        System.out.println(integers.isEmpty());

        integers.removeFirst();
        integers.removeLast();
        integers.printList();

        integers.addLast(13);
        integers.remove(2);  
        integers.printList();

    }
}

class ListaSimple<T> {
    private Node<T> first;
    private int size;

    public ListaSimple() {
        this.first = null;
        this.size = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.setNextNode(first);
            first = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> aux = first;
            while (aux.getNextNode() != null) {
                aux = aux.getNextNode();
            }
            aux.setNextNode(newNode);
            size++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        } else {
            Node<T> next = first.getNextNode(); // obtiene el siguiente nodo al primero
            first.setdata(null); // cambia el primer nodo a null
            first = next; // el primer nodo es ahora el siguiente
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        } else {
            Node<T> aux = first;
            while (aux.getNextNode().getNextNode() != null) {
                aux = aux.getNextNode();
            }
            aux.setNextNode(null);
            size--;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("error index");
        }

        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        } else {
            if (index == 0) {
                removeFirst();
                return;
            }
            if (index == size - 1) {
                removeLast();
                return;
            }
        }

        Node<T> aux = first;
        for (int i = 1; i == index - 1; i++) {
            aux = aux.getNextNode();
        }

        aux.setNextNode(aux.getNextNode().getNextNode());
        size--;
    }

    public boolean isEmpty() {
        if (first == null && size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node<T> aux = first;
        String message = "[";
        do {
            message += aux.getdata() + " ";
            aux = aux.getNextNode();
        } while (aux != null);

        message += "]";
        System.out.println(message);
    }
}

class Node<T> {
    private Node<T> nextNode;
    private T data;

    public Node(T data) {
        this.nextNode = null;
        this.data = data;
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