package Trees;

public class BinaryToSumTree {
    public static int convertToSumTree(Node root)
    {
        // base case: tree is empty
        if (root == null) {
            return 0;
        }

        // recursively convert left and right subtree first before
        // processing the root node
        int left = convertToSumTree(root.left);
        int right = convertToSumTree(root.right);

        // stores current value of root node
        int old = root.data;

        // update root to sum of left and right subtree
        root.data = left + right;

        // return the updated value plus old value (sum of tree rooted at root node)
        return root.data + old;
    }
}
