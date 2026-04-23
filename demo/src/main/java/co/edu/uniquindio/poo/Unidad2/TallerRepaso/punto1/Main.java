package co.edu.uniquindio.poo.Unidad2.TallerRepaso.punto1;

import co.edu.uniquindio.poo.Unidad2.Colas.Queue;

public class Main {
    public static void reverse(Queue<Integer> cola) {

        if (cola.isEmpty()) {
            return;
        }

        int x = cola.dequeue();
        reverse(cola);
        

    }

    public static void main(String[] args) {
        Queue<Integer> cola = new Queue<>();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);
        reverse(cola);
        System.out.println(cola);

    }

}
