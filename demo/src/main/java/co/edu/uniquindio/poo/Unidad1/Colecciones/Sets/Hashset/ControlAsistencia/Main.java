package co.edu.uniquindio.poo.Unidad1.Colecciones.Sets.Hashset.ControlAsistencia;

/*
Diseñar una clase Estudiante con id, nombre y programa, donde la igualdad esté definida únicamente por el id,
implementando correctamente equals() y hashCode().
Usar un HashSet<Estudiante> para evitar registros duplicados de asistencia y crear un método registrarAsistencia(Estudiante e)
que retorne true si el estudiante se agrega y false si ya existía. Recorrer los asistentes usando Iterator. 
Se evalúa comprensión de cómo HashSet detecta duplicados mediante hash y equals.
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Universidad universidad = new Universidad("Uniquindio");

        Estudiante estudiante1 = new Estudiante("Juan", 20, "123");
        Estudiante estudiante2 = new Estudiante("Maria", 22, "456");
        Estudiante estudiante3 = new Estudiante("Pedro", 21, "123"); // mismo id que estudiante1
        Estudiante estudiante4 = new Estudiante("Ana", 23, "789");

        System.out.println("Registrando asistencia:");
        System.out.println(universidad.registrarAsistencia(estudiante1)); // true
        System.out.println(universidad.registrarAsistencia(estudiante2)); // true
        System.out.println(universidad.registrarAsistencia(estudiante3)); // false, mismo id que estudiante1
        System.out.println(universidad.registrarAsistencia(estudiante4)); // true

        System.out.println("\nLista de estudiantes presentes:");
        universidad.mostrarAsistencia();

    }
}

class Estudiante {
    private String nombre;
    private int edad;
    /*
     * se marca como final para que no pueda ser modificado, ya que es el atributo
     * que se va a usar para comparar los objetos y evitar duplicados en el HashSet
     */
    private final String id;

    public Estudiante(String nombre, int edad, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", edad=" + edad + ", id=" + id + "]";
    }

    @Override
    public int hashCode() {
        return id.hashCode(); // permite generar el codigo hash del atributo en especifico
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true; // se encarga de verificar si son el mismo objeto
        if (obj == null || getClass() != obj.getClass())
            return false; // verifica que no sea null y del mismo tipo
        Estudiante that = (Estudiante) obj; // se indica que obj sea del tipo Estudiante para evitar errores
        return id.equals(that.id); // compara el atributo id
    }
}

class Universidad {
    private String nombre;
    private Set<Estudiante> estudiantes;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean registrarAsistencia(Estudiante estudiante) {
        // El método add de HashSet devuelve true si el elemento se agregó
        // correctamente,

        return estudiantes.add(estudiante); // devuelve true si se agrega, false si ya existe (mismo id)
    }

    public void mostrarAsistencia() {
        Iterator<Estudiante> it = estudiantes.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
