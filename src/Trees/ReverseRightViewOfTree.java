package Trees;

import org.w3c.dom.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReverseRightViewOfTree {
    static Deque<Integer> deque  = new LinkedList<>();
    public static void reverserightview(TreeNode root, int level)
    {
        if(root == null)
            return;

        if(deque.size() == level)
            // addfirst is for reverse addition
            deque.addFirst(root.data);
        // move to right node
        reverserightview(root.right, level+1);
        reverserightview(root.left, level+1);


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);
        root.left.right.right = new TreeNode(45);
       reverserightview(root, 0);
        System.out.println(deque);

    }
}
