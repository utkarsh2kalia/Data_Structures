package Trees;

import static Trees.InorderTraversal.maketree;
import static Trees.SpiralOrderTraversal.zigzagLevelOrder;

public class DiameterOfATree {
//    Given a binary tree, you need to compute the length of the diameter of the tree.
//    The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
//    This path may or may not pass through the root.
//
//    Example:
//    Given a binary tree
//                   1
//                  / \
//                  2   3
//                  / \
//                  4   5
//    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

//    Note: The length of path between two nodes is represented by the number of edges between them.
//max(depth of node.left, depth of node.right) + 1
//

    int max = 0;
// we are counting the number of edges in this question
    public int diameterofBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
//        calculate diameter "through" the current node
        max = Math.max(max, left + right);
        // important - return height of subtree rooted at current node
        return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,32,65,33,98,10};
        TreeNode root = maketree(arr);
//        System.out.println(zigzagLevelOrder(root));

        System.out.println((new DiameterOfATree()).diameterofBinaryTree(root));
    }

}
