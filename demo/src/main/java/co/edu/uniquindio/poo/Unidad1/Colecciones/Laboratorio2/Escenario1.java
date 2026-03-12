package co.edu.uniquindio.poo.Unidad1.Colecciones.Laboratorio2;

import java.util.LinkedHashSet;
import java.util.Set;

public class Escenario1 {

    public static void main(String[] args) {

        int[] sizes = { 100, 1000, 10000, 100000 };

        for (int n : sizes) {

            Hospital h = new Hospital();

            Runtime runtime = Runtime.getRuntime();

            // Limpia memoria aproximada
            runtime.gc();

            long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

            for (int i = 0; i < n; i++) {
                Patient p = new Patient("Paciente" + i, "ID" + i);
                h.addPacient(p);
            }

            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            long start = System.nanoTime();

            h.searchPacient("ID" + (n - 1));

            long end = System.nanoTime();

            long time = end - start;
            long memoryUsed = memoryAfter - memoryBefore;

            System.out.println("Tamaño de datos: " + n);
            System.out.println("Tiempo de ejecución (ns): " + time);
            System.out.println("Memoria usada aproximada (bytes): " + memoryUsed);
            System.out.println("-----------------------------------");
        }
    }
}

class Hospital {

    Set<Patient> s = new LinkedHashSet<>();

    public void addPacient(Patient paciente) {
        s.add(paciente);
    }

    public Patient searchPacient(String id) {

        Patient patientWanted = null;

        for (Patient patient : s) {
            if (patient.getId().equals(id)) {
                patientWanted = patient;
                break;
            }
        }

        return patientWanted;
    }
}

class Patient {

    private String id;
    private String name;

    public Patient(String name, String id) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", name=" + name + "]";
    }
}