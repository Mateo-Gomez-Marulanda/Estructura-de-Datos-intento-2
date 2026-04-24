package co.edu.uniquindio.poo.Unidad2.quiz;

class Node {
    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class Main {

    static int strange(Node n, int acc) {
        if (n == null) {
            return acc;
        }

        if (n.val % 2 == 0) {
            acc += n.val;
        } else {
            acc -= n.val;
        }

        int r = strange(n.next, acc);

        if (n.next != null && n.val > n.next.val) {
            n.next = n.next.next;
        }

        return r;
    }

    public static void main(String[] args) {
        Node list = new Node(3,
                    new Node(6,
                    new Node(2,
                    new Node(5,
                    new Node(4, null)))));

        int res = strange(list, 0);
        System.out.println(res);
    }
}
