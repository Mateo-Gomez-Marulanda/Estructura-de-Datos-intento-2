package co.edu.uniquindio.poo.Unidad2.quiz;

import java.util.Queue;
import java.util.LinkedList;

public class ReverseQueue {

    // Método recursivo para invertir la cola
    public static void invertir(Queue<Integer> q) {
        if (q.isEmpty())
            return;

        int frente = q.poll(); // saca el primero
        invertir(q); // invierte el resto
        q.offer(frente); // lo agrega al final
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);

        invertir(q);

        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }
}
