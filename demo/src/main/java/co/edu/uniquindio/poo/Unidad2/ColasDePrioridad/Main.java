package co.edu.uniquindio.poo.Unidad2.ColasDePrioridad;

import co.edu.uniquindio.poo.Unidad2.ColasDePrioridad.PriorityQueueBase.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Crear una cola de prioridad para pacientes en una sala de emergencias
        PriorityQueue<String> colaPacientes = new PriorityQueue<>();

        System.out.println("=== COLA DE PRIORIDAD - EMERGENCIAS ===\n");
        System.out.println("Capacidad inicial: 10 elementos\n");
        
        // Encolar más de 10 pacientes para forzar el resize
        // Cada vez que lleguemos a la capacidad máxima, resize() se llamará automáticamente
        System.out.println("Encolando 25 pacientes para demostrar el resize()...\n");
        
        colaPacientes.enqueue("Paciente 01 - Accidente grave", 1);
        colaPacientes.enqueue("Paciente 02 - Consulta", 4);
        colaPacientes.enqueue("Paciente 03 - Cirugía urgente", 2);
        colaPacientes.enqueue("Paciente 04 - Revisión", 5);
        colaPacientes.enqueue("Paciente 05 - Emergencia", 1);
        colaPacientes.enqueue("Paciente 06 - Fractura", 3);
        colaPacientes.enqueue("Paciente 07 - Apendicitis", 2);
        colaPacientes.enqueue("Paciente 08 - Cita rutinaria", 6);
        colaPacientes.enqueue("Paciente 09 - Quemaduras", 1);
        colaPacientes.enqueue("Paciente 10 - Control", 5);
        // Estos 10 primeros llenan la capacidad inicial, ahora resize() se activa
        System.out.println("✓ Primeros 10 pacientes encolados (capacidad inicial alcanzada)");
        System.out.println("  Tamaño: " + colaPacientes.size());
        System.out.println("  → resize() se activará al agregar el paciente 11\n");
        
        colaPacientes.enqueue("Paciente 11 - Derrame cerebral", 1);
        System.out.println("✓ Paciente 11 encolado (resize() ejecutado: 10 → 20)");
        
        colaPacientes.enqueue("Paciente 12 - Infarto", 1);
        colaPacientes.enqueue("Paciente 13 - Envenenamiento", 2);
        colaPacientes.enqueue("Paciente 14 - Asfixia", 1);
        colaPacientes.enqueue("Paciente 15 - Hemorragia", 2);
        colaPacientes.enqueue("Paciente 16 - Shock", 1);
        colaPacientes.enqueue("Paciente 17 - Coma", 1);
        colaPacientes.enqueue("Paciente 18 - Paro cardíaco", 1);
        colaPacientes.enqueue("Paciente 19 - Convulsiones", 2);
        colaPacientes.enqueue("Paciente 20 - Respiración comprometida", 1);
        System.out.println("✓ Pacientes 12-20 encolados");
        System.out.println("  Tamaño: " + colaPacientes.size());
        System.out.println("  → resize() se activará al agregar el paciente 21\n");
        
        colaPacientes.enqueue("Paciente 21 - Traumatismo", 1);
        System.out.println("✓ Paciente 21 encolado (resize() ejecutado: 20 → 40)");
        
        colaPacientes.enqueue("Paciente 22 - Deshidratación severa", 3);
        colaPacientes.enqueue("Paciente 23 - Cetoacidosis", 2);
        colaPacientes.enqueue("Paciente 24 - Trombosis", 2);
        colaPacientes.enqueue("Paciente 25 - Neumonía grave", 2);
        System.out.println("✓ Pacientes 22-25 encolados\n");

        System.out.println("=== ESTADÍSTICAS FINALES ===");
        System.out.println("Total de pacientes encolados: " + colaPacientes.size());
        System.out.println("Elemento con mayor prioridad: " + colaPacientes.peek());
        System.out.println("Prioridad: " + colaPacientes.peekPriority());

        System.out.println("\n=== ATENDIENDO PACIENTES (orden de prioridad) ===\n");

        // Desencolar pacientes en orden de prioridad
        int contador = 1;
        while (!colaPacientes.isEmpty()) {
            System.out.println(contador + ". " + colaPacientes.dequeue());
            contador++;
        }

        System.out.println("\n=== COLA VACÍA ===");
        System.out.println("¿Cola vacía? " + colaPacientes.isEmpty());
        System.out.println("Tamaño: " + colaPacientes.size());
    }
}
