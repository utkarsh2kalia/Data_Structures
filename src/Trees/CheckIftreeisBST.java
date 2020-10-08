package Trees;

import org.w3c.dom.Node;

import java.util.Stack;

import static Trees.InorderTraversal.maketree;

public class CheckIftreeisBST {
    // using stack
    public static boolean isBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // initial value to compare the leftmost node with, consider it as the root value for initial cause
        double prev = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            // move left
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // pop out
            root = stack.pop();

            // prev marks the left tree data, so root should be greater than it
            if (root.data <= prev) {
                return false;
            }
            prev = root.data;

            //now check for the right data
            root = root.right;


        }
        return true;
    }
    // using recusrsion
    boolean checkBST(TreeNode root) {
        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean check(TreeNode n, int min, int max){
        if(n==null)
            return true;
        if(n.data <= min || n.data >= max)
            return false;
        return check(n.left, min, n.data)
                && check(n.right, n.data, max);
    }

    public static void main(String[] args) {
        int keys[] = {2,3,1,1,1,1,1,1,5,4,4,3,3,3};

        System.out.println(isBST(maketree(keys)));
    }
}







