package co.edu.uniquindio.poo.Unidad2.quiz;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class List {
    Node head;

    // Método público
    public void invertir() {
        head = invertirRec(head);
    }

    // Método recursivo
    private Node invertirRec(Node actual) {
        if (actual == null || actual.next == null) {
            return actual; // nuevo head
        }

        Node nuevoHead = invertirRec(actual.next);

        actual.next.next = actual; // invierte enlace
        actual.next = null; // corta enlace original

        return nuevoHead;
    }
}

public class ReverseList {
    public static void main(String[] args) {
        List lista = new List();

        lista.head = new Node(1);
        lista.head.next = new Node(2);
        lista.head.next.next = new Node(3);
        lista.head.next.next.next = new Node(4);

        lista.invertir();

        Node temp = lista.head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
