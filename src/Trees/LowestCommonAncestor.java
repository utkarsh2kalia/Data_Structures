package Trees;

public class LowestCommonAncestor {
    public static Node findLCA(Node root, Node x, Node y) {
        // base case 1: if tree is empty
        if (root == null)
            return null;

        // base case 2: if either x or y is found
        if (root == x || root == y)
            return root;

        // recursively check if x or y exists in the left subtree
        Node left = findLCA(root.left, x, y);

        // recursively check if x or y exists in the right subtree
        Node right = findLCA(root.right, x, y);

        // if x is found in one subtree and y is found in other subtree,
        // update lca to current node
        if (left != null && right != null) {
            return root;
        }

        // if x and y exists in left subtree
        if (left != null) {
            return left;
        }

        // if x and y exists in right subtree
        if (right != null) {
            return right;
        }

        return null;
    }
}
