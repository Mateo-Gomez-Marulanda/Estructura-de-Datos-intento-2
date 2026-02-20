package co.edu.uniquindio.poo.Unidad1.Recursividad.DivideVenceras.BusquedaBinaria;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // el arreglo debe estar previamente ordenado
        int[] arreglo = { 1, 2, 3, 4, 5, 6, 7 };

        Arrays.sort(arreglo);

        int busquedaBinaria = busquedaBinaria(arreglo, 0, arreglo.length - 1, 5);
        System.out.println("indice elemento en el arreglo " + busquedaBinaria);
    }

    /*
     * la variable n es el numero que se busca en el arreglo
     */

    // busqueda binaria con Recursividad
    private static int busquedaBinaria(int[] arreglo, int cabeza, int cola, int n) {


        // *busca binariamente*
        if (cabeza > cola) {
            return -1;
        }

        int mitad = (cabeza + cola) / 2;

        if (n == arreglo[mitad]) {
            return mitad;
        }

        if (n > arreglo[mitad]) {
            // busca en el lado izquierdo
            return busquedaBinaria(arreglo, mitad + 1, cola, n);
        } else {
            // busca en el lado derecho
            return busquedaBinaria(arreglo, cabeza, mitad - 1, n);
        }
    }

    // busqueda binaria con Iteraciones
    private static int busquedaBinariaIterativa(int[] arreglo, int cabeza, int cola, int n) {
        // algun dia lo hare XD
        return -1;
    }

}
