package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto8;

import java.util.Stack;

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
        System.out.println(splitStack(stack, 6));

    }

    public static Pair<Stack<Integer>, Stack<Integer>> splitStack(Stack<Integer> s, int i) {

        Stack<Integer> aux1 = new Stack<>();
        Stack<Integer> aux2 = new Stack<>();

        if (i < 0 || i >= s.size()) {
            System.out.println("Índice inválido");
            return new Pair(aux1, aux2);
        }

        for (int index = 0; index < i; index++) {
            aux1.push(s.get(index));
        }

        for (int index = i; index < s.size(); index++) {
            aux2.push(s.get(index));
        }

        return new Pair(aux1, aux2);
    }
}

// S1 y S2 hacen referencia a stack 1 y 2
class Pair<S1, S2> {
    private S1 mitad1;
    private S2 mitad2;

    public Pair(S1 mitad1, S2 mitad2) {
        this.mitad1 = mitad1;
        this.mitad2 = mitad2;
    }

    public S1 getMitad1() {
        return mitad1;
    }

    public void setMitad1(S1 mitad1) {
        this.mitad1 = mitad1;
    }

    public S2 getMitad2() {
        return mitad2;
    }

    public void setMitad2(S2 mitad2) {
        this.mitad2 = mitad2;
    }

    @Override
    public String toString() {
        return "Pair [mitad1=" + mitad1 + ", mitad2=" + mitad2 + "]";
    }
}