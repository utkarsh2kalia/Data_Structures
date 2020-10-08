package Trees;

import com.sun.source.tree.Tree;

import static Trees.InorderTraversal.inordertraversal;
import static Trees.InorderTraversal.maketree;
import static Trees.SpiralOrderTraversal.zigzagLevelOrder;

public class HeightOfBinaryTree {
    public static int treeheight(TreeNode root)
    {
        if(root == null)
            return 0;
        return Math.max(1+treeheight(root.left), 1+treeheight(root.right));
    }

    public static void main(String[] args) {
        int arr[] = {1,2,4,32,65,33,98,10};
        TreeNode root = maketree(arr);
        System.out.println(zigzagLevelOrder(root));
        System.out.println(treeheight(root));
    }
}
