package co.edu.uniquindio.poo.Unidad1.Recursividad.Matriz;

//matriz recursiva

public class Main {
    public static void main(String[] args) {
        int[][] matriz = {
                { 1, 2, 3, 10 },
                { 4, 7, 6, 11 },
                { 7, 8, 9, 12 }
        };

        recorrerMatriz(matriz, 0, 0);
        System.out.println(sumarDiagonalPrincipal(matriz, 0, 0));
    }

    /*
     * el metodo para recorrer la matriz de manera recursiva consiste en recorrer la
     * primera fila e imprimir cada columna de la fila, luego seguir con la fila
     * siguiente y repetir el proceso
     */

    private static void recorrerMatriz(int[][] matriz, int fila, int columna) {

        // caso base
        if (matriz.length == fila) { // verifica que no se supere el numero de filas
            return;
        }

        // caso recursivo
        System.out.print(matriz[fila][columna] + " "); // imprime el elemento en la posicion especifica
        if (columna < matriz[fila].length - 1) { // recorre cada columna de la fila
            recorrerMatriz(matriz, fila, columna + 1);
        } else {
            System.out.println();
            // una vez se recorrentodos las columnas de un fila se pasa a la siguientes
            recorrerMatriz(matriz, fila + 1, 0);
        }
    }

    private static int sumarDiagonalPrincipal(int[][] matriz, int fila, int columna) {

        if (matriz.length == fila || matriz[fila].length == columna) {
            return 0;
        }

        return matriz[fila][columna] + sumarDiagonalPrincipal(matriz, fila + 1, columna + 1);
    }
}
