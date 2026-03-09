package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto5;

import java.util.Stack;

/*
1. crear metodo spliceStack
2. el metodo tiene como parametro un stack s
3. se debe hacer un recorrido desde i 
4. i seria un elemento desde la base de la pila
5. i no se toma para esta secuencia
6. se debe llegar hasta un j que representa la cima
7. la posicion 0 en la base de la pila
8. retornar los valores de la secuencia en una nueva pila
9. se debe conservar el orden 
*/

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4); // 0
        stack.push(5); // 1
        stack.push(6); // 2
        stack.push(1); // 3
        stack.push(2); // 4
        stack.push(3); // 5
        stack.push(7); // 6
        stack.push(8); // 7

        System.out.println(stack);
        System.out.println(spliceStack(stack, 4, 7));
        System.out.println(stack);

    }

    public static Stack<Integer> spliceStack(Stack<Integer> s, int i, int j) {
        Stack<Integer> newStack = new Stack<>();

        if (i >= j || i < 0 || j > s.size()) {
            System.out.println("Índices inválidos");
            return newStack;
        }

        // 1. Copiar los elementos de i+1 a j-1 en la nueva pila
        for (int index = i + 1; index <= j; index++) {
            newStack.push(s.get(index));
        }

        // 2. Remover los elementos de la pila original (de atrás hacia adelante)
        for (int index = j - 1; index > i; index--) {
            s.remove(index);
        }
        return newStack;
    }
}
