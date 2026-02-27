package co.edu.uniquindio.poo.Unidad1.Colecciones.Lista.BalanceoParentesis;

import java.util.Stack;

/*
Reglas
Una expresión está balanceada cuando:
Cada ( tiene su )
Cada { tiene su }
Cada [ tiene su ]
Los símbolos se cierran en el orden correcto
El sistema debe:
Recibir una expresión (String).
Verificar si los símbolos están correctamente balanceados.
Retornar:


"Expresión válida" si está balanceada.
"Expresión inválida" en caso contrario.

*/

public class Main {
    public static void main(String[] args) {

        String expresion1 = "({[]})";
        String expresion2 = "({[})";
        String expresion3 = "((()))";
        String expresion4 = "({)}";

        System.out.println("Expresión: " + expresion1);
        BalanceoParentesis.balenceoParentesis(expresion1);

        System.out.println("\nExpresión: " + expresion2);
        BalanceoParentesis.balenceoParentesis(expresion2);

        System.out.println("\nExpresión: " + expresion3);
        BalanceoParentesis.balenceoParentesis(expresion3);

        System.out.println("\nExpresión: " + expresion4);
        BalanceoParentesis.balenceoParentesis(expresion4);

    }
}

class BalanceoParentesis {

    public static void balenceoParentesis(String expresion) {
        Stack<Character> stack = new Stack<>();

        for (char c : expresion.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') { // Verifica si el carácter es un símbolo de apertura
                stack.push(c); // Guarda el símbolo de apertura en la pila
            } else if (c == ')' || c == '}' || c == ']') { // Verifica si el carácter es un símbolo de cierre
                if (stack.isEmpty()) { // Si no hay aperturas pendientes en la pila
                    System.out.println("Expresión inválida"); //
                    return;
                }
                char top = stack.pop(); // Extrae el último símbolo de apertura guardado
                
                // Comprueba si apertura y cierre no coinciden
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    System.out.println("Expresión inválida");
                    return;
                }
            }
        }

        if (stack.isEmpty()) { // Si no quedaron aperturas sin cerrar
            System.out.println("Expresión válida");
        } else { // Si todavía hay símbolos de apertura pendientes
            System.out.println("Expresión inválida");
        }
    }

}