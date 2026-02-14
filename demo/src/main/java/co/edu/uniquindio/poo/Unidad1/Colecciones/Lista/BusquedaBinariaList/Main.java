package co.edu.uniquindio.poo.Unidad1.Colecciones.Lista.BusquedaBinariaList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(4);
        lista.add(8);
        lista.add(99);
        lista.add(1);
        lista.add(6);
        lista.add(100);

        lista.sort(Integer::compareTo);

        /*
         * otras formas de ordenar la lista de elementos
         * 
         * 1. Collections.sort(lista); desde la interfaz Collections hace el sort de la
         * lista
         * 
         * 2. lista.sort((a, b) -> a.compareTo(b)); compara el elemento actual con el
         * siguiente usando compareTo() (lamda)
         * 
         * 3. lista.sort(Comparator.naturalOrder()); realiza la comparacion mediante el
         * orden natural de la interfaz
         * 
         * bonus
         * lista.sort(Comparator.reverseOrder()); para organizar de manera decendente
         */

        int busquedaBinaria = busquedaBinaria(lista, 0, lista.size() - 1, 6);
        System.out.println("indice elemento en la lista " + busquedaBinaria);
    }

    private static int busquedaBinaria(ArrayList<Integer> lista, int cabeza, int cola, int n) {
        // *busca binariamente*

        if (cabeza > cola) {
            return -1;
        }

        int mitad = (cabeza + cola) / 2;

        if (n == lista.get(mitad)) {
            return mitad;
        }

        if (n > lista.get(mitad)) {
            return busquedaBinaria(lista, mitad + 1, cola, n);
        } else {
            return busquedaBinaria(lista, cabeza, mitad - 1, n);

        }
    }
}
