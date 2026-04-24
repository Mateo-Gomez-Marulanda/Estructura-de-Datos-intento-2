package co.edu.uniquindio.poo.Unidad2.quiz;

import java.util.Stack;

public class StacktoQueue {

    private Stack<Integer> input; // Pila de entrada
    private Stack<Integer> output; // Pila de salida

    public StacktoQueue() {
        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    /**
     * Agrega un elemento a la cola (enqueue)
     * Operación: O(1)
     */
    public void enqueue(int value) {
        input.push(value);
        System.out.println("📥 Enqueue: " + value);
    }

    /**
     * Extrae el primer elemento de la cola (dequeue)
     * Operación: O(n) en el peor caso (cuando hay que invertir)
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("❌ Cola vacía - No se puede hacer dequeue");
        }

        // Si output está vacío, invertir todos los elementos de input
        if (output.isEmpty()) {
            System.out.println("  🔄 Invirtiendo input → output...");
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        int value = output.pop();
        System.out.println("📤 Dequeue: " + value);
        return value;
    }

    /**
     * Ver el primer elemento sin sacarlo (peek)
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("❌ Cola vacía");
        }

        if (output.isEmpty()) {
            // Invertir pero sin sacar
            Stack<Integer> temp = new Stack<>();
            while (!input.isEmpty()) {
                temp.push(input.pop());
            }
            while (!temp.isEmpty()) {
                output.push(temp.pop());
            }
        }

        return output.peek();
    }

    /**
     * Verifica si la cola está vacía
     */
    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    /**
     * Retorna el tamaño de la cola
     */
    public int size() {
        return input.size() + output.size();
    }

    /**
     * Imprime el estado de la cola
     */
    public void mostrarEstado() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("INPUT (Pila entrada):  " + input);
        System.out.println("OUTPUT (Pila salida):  " + output);
        System.out.println("Tamaño: " + size());
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }

    public static void main(String[] args) {
        StacktoQueue cola = new StacktoQueue();

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  EMULANDO COLA CON DOS PILAS           ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // Agregando elementos
        System.out.println("--- FASE 1: Enqueue ---");
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.enqueue(40);
        cola.mostrarEstado();

        // Sacando elementos
        System.out.println("--- FASE 2: Dequeue ---");
        cola.dequeue(); // Aquí ocurre la inversión
        cola.mostrarEstado();

        cola.dequeue();
        cola.mostrarEstado();

        // Agregando más
        System.out.println("--- FASE 3: Enqueue más elementos ---");
        cola.enqueue(50);
        cola.enqueue(60);
        cola.mostrarEstado();

        // Sacando todo
        System.out.println("--- FASE 4: Dequeue resto ---");
        cola.dequeue();
        cola.mostrarEstado();

        cola.dequeue();
        cola.mostrarEstado();

        cola.dequeue();
        cola.mostrarEstado();

        cola.dequeue();
        cola.mostrarEstado();

        // Verificar si está vacía
        System.out.println("¿Cola vacía? " + cola.isEmpty());

        try {
            cola.dequeue();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
