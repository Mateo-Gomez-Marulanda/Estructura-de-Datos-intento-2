package co.edu.uniquindio.poo.Unidad1.Recursividad.DivideVenceras.NumeroMayor;

public class Main {
    public static void main(String[] args) {
        int[] arreglo = { 1, 2, 3, 4, 5, 6, 7 };

        System.out.println("forma recursiva\n");
        System.out.println(numeroMayor(arreglo, 0, arreglo.length - 1));

        System.out.println(" ");

        System.out.println("forma iterativa\n");
        System.out.println(mayorElemento(arreglo));
    }

    // recurisivo (divide y venceras)
    private static int numeroMayor(int[] arreglo, int cabeza, int cola) {

        // caso base cuando no hayan elementos en la sub lista
        if (cabeza == cola) {
            return arreglo[cabeza];
        }

        // se haya la mitad de la suma de la cabeza y cola para hallar la mitad del
        // arreglo
        int mitad = (cabeza + cola) / 2;

        int maximoIz = numeroMayor(arreglo, cabeza, mitad); // se empiezan a dividir desde la mitad de la izquierda

        int maximoDe = numeroMayor(arreglo, mitad + 1, cola); // se empiezan a dividir desde la mitad de la derecha

        // se empiezan a comparar cada uno de los elemento que fueron previamente
        // divididos
        return Math.max(maximoIz, maximoDe);
    }

    // iterativo
    private static int mayorElemento(int[] arreglo) {
        int mayor = Integer.MIN_VALUE; // se usa esta constante para facilitar el proceso

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > mayor) {
                mayor = arreglo[i];
            }
        }
        return mayor;
    }
}