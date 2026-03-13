// package co.edu.uniquindio.poo.Unidad1.Colecciones.Sets.RegistroEstudiantes;

// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Iterator;
// import java.util.List;
// import java.util.NavigableSet;
// import java.util.TreeSet;

// public class Main {
//     public static void main(String[] args) {

//     }
// }

// class RegistroEstudiantes<T> {
//     private HashSet<T> estudiantes;
//     private TreeSet<T> ranking;

//     public RegistroEstudiantes() {
//         this.estudiantes = new HashSet<>();
//         this.ranking = new TreeSet<>();
//     }

//     public void registrar(T estudiante) {
//         estudiantes.add(estudiante);
//         ranking.add(estudiante);
//     }

//     public void eliminar(T estudiante) {
//         estudiantes.remove(estudiante);
//         ranking.remove(estudiante);
//     }

//     public boolean existe(T estudiante) {
//         return estudiantes.contains(estudiante);
//     }

//     public int total() {
//         return estudiantes.size();
//     }

//     public List<T> topN(int n){
//         List<T> notas = new ArrayList<>(ranking);
        
//         NavigableSet<T> it = ranking.descendingSet();
//        for(T estudiante : it){
        
//         if(){}
//         notas.add(estudiante);
//        }

//         return notas;
//     }
// }

// class Estudiante implements Comparable<Estudiante> {
//     private String nombre;
//     private int edad;
//     private double promedio;

//     public Estudiante(String nombre, int edad, double promedio) {
//         this.nombre = nombre;
//         this.edad = edad;
//         this.promedio = promedio;
//     }

//     @Override
//     public int compareTo(Estudiante o) {
//         return Double.compare( o.promedio, this.promedio);
//     }

//     public void setNombre(String nombre) {
//         this.nombre = nombre;
//     }

//     public void setEdad(int edad) {
//         this.edad = edad;
//     }

//     public void setPromedio(double promedio) {
//         this.promedio = promedio;
//     }

//     public String getNombre() {
//         return nombre;
//     }

//     public int getEdad() {
//         return edad;
//     }

//     public double getPromedio() {
//         return promedio;
//     }
// }