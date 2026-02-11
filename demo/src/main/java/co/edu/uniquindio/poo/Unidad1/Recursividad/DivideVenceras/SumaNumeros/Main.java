package co.edu.uniquindio.poo.Unidad1.Recursividad.DivideVenceras.SumaNumeros;

public class Main {
    public static void main(String[] args) {

        int[] arreglo = { 1, 2, 3, 4, 5, 6, 7 };

        System.out.println("implementa divide y venceras");
        System.out.println(sumaRecurisva(arreglo, 0, arreglo.length - 1));

        System.out.println();
        
        System.out.println("recursividad normal");
        System.out.println(sumarArreglo(arreglo, 0));
    }

    // version con divide y venceras
    private static int sumaRecurisva(int[] arreglo, int cabeza, int cola) {
        // caso base
        if (cabeza == cola) {
            return arreglo[cabeza];
        }

        int mitad = (cabeza + cola) / 2;

        int sumaIz = sumaRecurisva(arreglo, cabeza, mitad); // suma del lado izquierdo
        int sumaDer = sumaRecurisva(arreglo, mitad + 1, cola); // suma del lado derecho

        return sumaIz + sumaDer; // se agrupan los resultados de cada lado
    }

    // version sin usar divide y venceras
    private static int sumarArreglo(int[] arreglo, int index) {
        if (index == arreglo.length) {
            return 0; // caso base
        }
        return arreglo[index] + sumarArreglo(arreglo, index + 1);
    }

}
