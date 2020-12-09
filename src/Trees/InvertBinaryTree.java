package Trees;

public class InvertBinaryTree {
    //interchange the left and right subtree of tree
    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;

    }

    public static void main(String[] args) {

    }


}
