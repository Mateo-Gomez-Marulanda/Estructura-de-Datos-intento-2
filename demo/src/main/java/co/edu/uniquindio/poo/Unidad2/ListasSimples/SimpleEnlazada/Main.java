package co.edu.uniquindio.poo.Unidad2.ListasSimples.SimpleEnlazada;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> integers = new SimpleLinkedList<>();

        System.out.println("La lista esta vacia? " + integers.isEmpty());
        integers.addFirst(2);
        integers.addFirst(3);
        integers.addFirst(5);
        integers.addFirst(7);
        integers.addFirst(11);

        integers.add(37, 2);
        System.out.println("\nel tamano de la lista es: " + integers.size());
       // integers.printList();

        System.out.println("\nLa lista esta vacia? " + integers.isEmpty());

        integers.removeFirst();
        integers.removeLast();
       // integers.printList();

        // integers.addLast(13);
        // integers.removeIndex(2);
        // integers.printList();

        System.out.println("\nvalor en la posicion 3: " + integers.get(3));

        System.out.println("buscando posicion... " + integers.indexOf(3));

        System.out.println();

        // integers.removeElement(3);
        // integers.printList();

        System.out.println("\ninvertir lista");
        // integers.reverse();
        // integers.printList();

        for (Integer data : integers) {
            System.out.println(data);
        }

        // List<Integer> list = List.of(12, 3, 4, 5, 6);
        // System.out.println(list.get(4) + " " + list.size());
        // System.out.println(list.indexOf(4));
        // list.reversed() ;
    }
}