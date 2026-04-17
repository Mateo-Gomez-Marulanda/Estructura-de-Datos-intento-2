package co.edu.uniquindio.poo.Unidad2.Pilas;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("apilando elementos...\n");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        for (Integer i : stack) {
            System.out.println(i);
        }

        System.out.println("desapilando elementos...\n");
        stack.pop();
        stack.pop();
        for (Integer i : stack) {
            System.out.println(i);
        }

        System.out.println(stack.peek());
    }
}