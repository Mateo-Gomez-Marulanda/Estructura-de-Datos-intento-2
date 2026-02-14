package co.edu.uniquindio.poo.Unidad1.Recursividad.Arreglo.ImprimirArreglo;

public class Main {
    public static void main(String[] args) {

        int[] arreglo = { 1, 2, 3, 4, 5, 6, };

        System.out.println("arreglo normal\n");
        imprimirArreglo(arreglo, 0);

        System.out.println("arreglo invertido\n");
        imprimirArregloInvertido(arreglo, 0);

        System.out.println("numero mayor\n" + numeroMayor(arreglo, 0, 0));

    }

    private static void imprimirArreglo(int[] arreglo, int index) {
        if (index == arreglo.length) {
            return;
        }

        System.out.println(arreglo[index]); // se imprimime la posicion actual
        imprimirArreglo(arreglo, index + 1);
    }

    private static void imprimirArregloInvertido(int[] arreglo, int index) {
        if (index == arreglo.length) {
            return;
        }

        imprimirArregloInvertido(arreglo, index + 1);
        System.out.println(arreglo[index]); // se imprimime la posicion actual
    }

    /*
     * primero tomar el elemento en la posicion del indice
     * verificar el elememto actual con el siguiente
     * si es mayor el contador lo gurda, si es menor se cambia por el del indicie
     * actual
     * recorrer hasta que el indice sea igual al tamano de la lista
     */

    private static int numeroMayor(int[] arreglo, int index, int contador) {

        if (index == arreglo.length) {
            return contador;
        }

        if (arreglo[index] > contador) {
            contador = arreglo[index];
        }
        
        return numeroMayor(arreglo, index + 1, contador);
    }
}
