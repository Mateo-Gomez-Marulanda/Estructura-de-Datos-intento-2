package co.edu.uniquindio.poo.Unidad2.quiz;

import java.util.Stack;

public class ProjectStack {

    public static double methodStack(Stack<Integer> stack1, Stack<Integer> stack2) {
        Stack<Integer> stack3 = new Stack<>();
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;

        while (!stack1.isEmpty()) {
            stack3.push(stack1.pop());
        }

        while (!stack3.isEmpty()) {
            int v4 = stack3.pop();
            if (v1 % 2 == 0) {
                stack2.push(v4);
                v2 += v4;
                v3++;
            }
            v1++;
        }
        return v3 > 0 ? (double) v2 / v3 : 0.0;
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        stack1.push(40);

        Stack<Integer> stack2 = new Stack<>();
        double v6 = methodStack(stack1, stack2);

        System.out.println(v6);
    }
}
