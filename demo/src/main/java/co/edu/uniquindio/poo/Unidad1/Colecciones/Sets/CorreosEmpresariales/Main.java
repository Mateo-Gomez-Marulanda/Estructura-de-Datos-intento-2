package co.edu.uniquindio.poo.Unidad1.Colecciones.Sets.CorreosEmpresariales;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/*
Guardar correos únicos usando HashSet<String> para evitar duplicados, luego convertirlos a lista y ordenarlos con Collections.sort(). 
Posteriormente rehacer el proceso usando directamente TreeSet<String> y comparar conceptualmente rendimiento y comportamiento entre ambas estructuras. 
Se evalúa diferencia práctica entre HashSet, TreeSet y uso de Collections.
*/

public class Main {
    public static void main(String[] args) {

        System.out.println("=== METODO 1: HashSet + ArrayList + Collections.sort() ===\n");
        
        // Inicio de medición HashSet
        long inicioHashSet = System.nanoTime();
        
        HashSet<String> emailSet = new HashSet<>();

        // Agregar correos electrónicos (con algunos duplicados)
        emailSet.add("juan@empresa.com");
        emailSet.add("maria@empresa.com");
        emailSet.add("juan@empresa.com"); // Duplicado
        emailSet.add("pedro@empresa.com");
        emailSet.add("ana@empresa.com");
        emailSet.add("luis@empresa.com");
        
        long tiempoHashSet = System.nanoTime() - inicioHashSet;
        
        System.out.println("Conjunto de correos electronicos (sin orden): ");
        System.out.println(emailSet);
        System.out.println("Tiempo HashSet: " + tiempoHashSet + " ns (" + tiempoHashSet/1000.0 + " μs)");

        // Inicio de medición conversión y ordenamiento
        long inicioConversionSort = System.nanoTime();
        
        List<String> emailList = new ArrayList<>(emailSet);
        Collections.sort(emailList);
        
        long tiempoConversionSort = System.nanoTime() - inicioConversionSort;
        long tiempoTotalMetodo1 = tiempoHashSet + tiempoConversionSort;
        
        System.out.println("\nLista de correos electronicos ordenados:");
        System.out.println(emailList);
        System.out.println("Tiempo conversión + ordenamiento: " + tiempoConversionSort + " ns (" + tiempoConversionSort/1000.0 + " μs)");
        System.out.println("TIEMPO TOTAL METODO 1: " + tiempoTotalMetodo1 + " ns (" + tiempoTotalMetodo1/1000.0 + " μs)");

        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== METODO 2: TreeSet (ordenamiento automático) ===\n");
        
        // Inicio de medición TreeSet
        long inicioTreeSet = System.nanoTime();
        
        TreeSet<String> emailTree = new TreeSet<>();
        // Agregar correos electrónicos (con algunos duplicados)
        emailTree.add("juan@empresa.com");
        emailTree.add("maria@empresa.com");
        emailTree.add("juan@empresa.com"); // Duplicado
        emailTree.add("pedro@empresa.com");
        emailTree.add("ana@empresa.com");
        emailTree.add("luis@empresa.com");
        
        long tiempoTreeSet = System.nanoTime() - inicioTreeSet;

        System.out.println("Arbol de correos electronicos (ordenados automaticamente): ");
        System.out.println(emailTree);
        System.out.println("TIEMPO TOTAL METODO 2: " + tiempoTreeSet + " ns (" + tiempoTreeSet/1000.0 + " μs)");

        // Comparación de rendimiento
        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== COMPARACION DE RENDIMIENTO ===\n");
        System.out.println("Método 1 (HashSet + Sort): " + tiempoTotalMetodo1 + " ns");
        System.out.println("Método 2 (TreeSet):         " + tiempoTreeSet + " ns");
        
        if (tiempoTotalMetodo1 < tiempoTreeSet) {
            double diferencia = ((double)tiempoTreeSet / tiempoTotalMetodo1);
            System.out.println("\nHashSet + Sort es " + String.format("%.2f", diferencia) + "x más rápido");
        } else {
            double diferencia = ((double)tiempoTotalMetodo1 / tiempoTreeSet);
            System.out.println("\nTreeSet es " + String.format("%.2f", diferencia) + "x más rápido");
        }

    }
}
