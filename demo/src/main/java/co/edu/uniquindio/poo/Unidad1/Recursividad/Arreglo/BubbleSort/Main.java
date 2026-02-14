package co.edu.uniquindio.poo.Unidad1.Recursividad.Arreglo.BubbleSort;

public class Main {
    public static void main(String[] args) {
        int[] numeros = { 5, 3, 8, 4, 2 };

        System.out.println("metodo recursivo");

        System.out.println("Antes de ordenar:");
        imprimir(numeros);

        burbujaRecursiva(numeros, numeros.length);

        System.out.println("Después de ordenar:");
        imprimir(numeros);

        System.out.println();

        System.out.println("metodo usando el ciclo for");

        int[] elementos = { 20, 3, 66, 18, 10 };

        System.out.println("Antes de ordenar:");
        imprimir(elementos);

        burbuja(elementos);

        System.out.println("Después de ordenar:");
        imprimir(elementos);
    }

    // forma recursiva
    private static void burbujaRecursiva(int[] arreglo, int n) {

        // Caso base
        if (n == 1) {
            return;
        }

        // Una pasada (equivalente al segundo for)
        for (int i = 0; i < n - 1; i++) {

            if (arreglo[i] > arreglo[i + 1]) {

                int temp = arreglo[i];
                arreglo[i] = arreglo[i + 1];
                arreglo[i + 1] = temp;
            }
        }

        // Llamada recursiva reduciendo el tamaño
        burbujaRecursiva(arreglo, n - 1);
    }

    // ciclo for
    private static void burbuja(int[] arreglo) {

        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (arreglo[j] > arreglo[j + 1]) {

                    // Intercambio
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void imprimir(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}