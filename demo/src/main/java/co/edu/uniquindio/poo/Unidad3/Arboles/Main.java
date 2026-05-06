package co.edu.uniquindio.poo.Unidad3.Arboles;

import co.edu.uniquindio.poo.Unidad3.Arboles.ArbolBase.*;

public class Main {
    public static void main(String[] args) {

        Tree<String> tree = new Tree<>();
        tree.put("A");
        tree.put("B");
        tree.put("C");
        tree.put("D");
        tree.put("E");

        System.out.println("Size: " + tree.size());
        tree.weight();

        System.out.println("Preorder:" + tree.preOrder());
        System.out.println("Inorder:" + tree.inOrder());
        System.out.println("Postorder:" + tree.postOrder());
        System.out.println("Level order:" + tree.levelOrder());

    }
}
