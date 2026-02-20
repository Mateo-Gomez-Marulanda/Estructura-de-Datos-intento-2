package co.edu.uniquindio.poo.Unidad1.Colecciones.Lista.OrdenarEstudiantes;

import java.util.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Universidad universidad = new Universidad("Universidad de los Andes", "Dr. Juan Pérez");
        universidad.agregarEstudiante(new Estudiante("Ana", "12345", 4.5));
        universidad.agregarEstudiante(new Estudiante("Carlos", "12346", 3.8));
        universidad.agregarEstudiante(new Estudiante("María", "12347", 4.2));
        universidad.agregarEstudiante(new Estudiante("Luis", "12348", 3.5));

        universidad.obtenerMayorPromedio();
        universidad.obtenerMenorPromedio();

        universidad.consultarRanking();

        universidad.actualizarPromedioEstudiante("12348", 4.6);
        universidad.obtenerMayorPromedio();
        universidad.consultarRanking();
        universidad.eliminarEstudiante("12345");

    }
}

class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private String id;
    private double promedio;

    public Estudiante(String nombre, String id, double promedio) {
        this.nombre = nombre;
        this.id = id;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante nombre: " + nombre + ", id: " + id + ", promedio: " + promedio;
    }

    @Override
    public int compareTo(Estudiante estudiante) {
        return Double.compare(estudiante.getPromedio(), this.promedio);
    }
}

class Universidad {

    private String nombre;
    private String NombreRector;
    private List<Estudiante> estudiantes = new ArrayList<>();

    public Universidad(String nombre, String nombreRector) {
        this.nombre = nombre;
        NombreRector = nombreRector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreRector() {
        return NombreRector;
    }

    public void setNombreRector(String nombreRector) {
        NombreRector = nombreRector;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);

    }

    public void eliminarEstudiante(String id) {
        estudiantes.removeIf(estudiante -> estudiante.getId().equals(id));

    }

    public void consultarPosicionEstudiante(int posicion) {
        System.out.println(estudiantes.get(posicion));
    }

    public void actualizarPromedioEstudiante(String id, double promedio) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId().equals(id)) {
                estudiante.setPromedio(promedio);
                break;
            }
        }
    }

    public void ordenarEstudiantes() {
        estudiantes.sort(Estudiante::compareTo);
    }

    public void obtenerMayorPromedio() {
        ordenarEstudiantes();
        System.out.println("Estudiante con mayor promedio: " + estudiantes.getFirst());
    }

    public void obtenerMenorPromedio() {
        ordenarEstudiantes();
        System.out.println("Estudiante con menor promedio: " + estudiantes.getLast());
    }

    public void consultarRanking() {
        ordenarEstudiantes();
        System.out.println(estudiantes);
    }
}
