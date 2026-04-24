package co.edu.uniquindio.poo.Unidad2.quiz;

import java.util.Stack;

public class ReverseStack {

    // Método principal: invierte la pila
    public static void invertir(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int fondo = removerFondo(stack); // saca el último elemento
        invertir(stack);                 // invierte el resto
        stack.push(fondo);               // lo pone arriba
    }

    // Método auxiliar recursivo: elimina y retorna el elemento del fondo
    private static int removerFondo(Stack<Integer> stack) {
        int top = stack.pop();

        if (stack.isEmpty()) {
            return top; // era el fondo
        }

        int fondo = removerFondo(stack);
        stack.push(top); // reconstruye la pila
        return fondo;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        invertir(s);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
