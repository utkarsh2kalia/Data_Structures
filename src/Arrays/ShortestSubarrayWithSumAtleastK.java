package Arrays;


import org.w3c.dom.Node;

import java.util.Stack;

// we will use the sliding window algorithm o solve the problem
public class ShortestSubarrayWithSumAtleastK {


    boolean checkBST(Node root) {
        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean check(Node n, int min, int max){
        if(n==null)
            return true;
        if(n.data <= min || n.data >= max)
            return false;
        return check(n.left, min, n.data)
                && check(n.right, n.data, max);
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack();
            double inorder = - Double.MAX_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // If next element in inorder traversal
                // is smaller than the previous one
                // that's not BST.
                if (root.val <= inorder) return false;
                inorder = root.val;
                root = root.right;
            }
            return true;
        }
    }
}
