package co.edu.uniquindio.poo.Unidad1.Colecciones.Lista.UsoMetodos;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(4);
        lista.add(8);
        lista.add(99);
        lista.add(1);
        lista.add(6);

        lista.addFirst(2);
        lista.addLast(100);

        System.out.println(lista);
        // lista.reversed().forEach(System.out::println);
        // System.out.println(lista);

        lista.sort(Integer::compareTo);
        System.out.println(lista);

        lista.set(4, 12);
        System.out.println(lista);

        lista.remove(4);
        System.out.println(lista);

        lista.clear();
        System.out.println(lista);
    }
}