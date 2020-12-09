package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversal {
    public static void printDiagonal(Node node, Map<Integer, List<Integer>> map, int diagonal) {

        if(node == null)
            return;
        map.putIfAbsent(diagonal, new ArrayList<>());
        map.get(diagonal).add(node.data);
        printDiagonal(node.left,map, diagonal+1);
        printDiagonal(node.right, map, diagonal);


    }


    public static void printDiagonal(Node root) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        printDiagonal(root, map, 0);
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }
    public static void main(String[] args)
    {
		/* Construct below tree
				  1
				/   \
		       /     \
		      2       3
		     /      /  \
		    /      /    \
		   4      5      6
				 / \
				/   \
		       7     8
	   */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        printDiagonal(root);
    }
}

