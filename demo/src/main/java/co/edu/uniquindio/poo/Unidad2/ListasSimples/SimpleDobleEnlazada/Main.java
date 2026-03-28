package co.edu.uniquindio.poo.Unidad2.ListasSimples.SimpleDobleEnlazada;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> integers = new DoubleLinkedList<>();

        System.out.println("La lista esta vacia? " + integers.isEmpty());
        integers.addFirst(2);
        integers.addFirst(3);
        integers.addFirst(5);
        integers.addLast(4);
        integers.add(37, 2);
        System.out.println("\nel tamano de la lista es: " + integers.size());
        integers.printList();
        System.out.println("La lista esta vacia? " + integers.isEmpty());

        System.out.println("\nmetodos para eliminar elementos: ");
        integers.removeFirst();
        integers.printList();

        integers.removeLast();
        integers.printList();

        integers.removeIndex(1);
        integers.printList();

        integers.addFirst(4);
        integers.addFirst(5);
        integers.addFirst(6);
        integers.removeElement(3);
        integers.printList();

        System.out.println("\nel tamano de la lista es: " + integers.size());
        integers.printList();

        // ========================================
        // ITERADOR HACIA ADELANTE (Forward Iterator)
        // ========================================
        System.out.println("\n--- ITERADOR ADELANTE (For-Each) ---");
        for (Integer num : integers) {
            System.out.print(num + " -> ");
        }
        System.out.println("FIN");

        // ========================================
        // ITERADOR HACIA ADELANTE (Explícito con while)
        // ========================================
        System.out.println("\n--- ITERADOR ADELANTE (Explícito con while) ---");
        Iterator<Integer> iterador = integers.iterator();
        while (iterador.hasNext()) {
            System.out.print(iterador.next() + " -> ");
        }
        System.out.println("FIN");

        // ========================================
        // ITERADOR INVERSO (Reverse Iterator)
        // ========================================
        System.out.println("\n--- ITERADOR INVERSO (Con while) ---");
        Iterator<Integer> reverseIterator = integers.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " <- ");
        }
        System.out.println("FIN");

        // ========================================
        // ITERADOR INVERSO (For-Each alternativo)
        // ========================================
        System.out.println("\n--- ITERADOR INVERSO (For-Each) ---");
        Iterator<Integer> revIter = integers.reverseIterator();
        while (revIter.hasNext()) {
            System.out.print(revIter.next() + " <- ");
        }
        System.out.println("FIN");
    }
}
