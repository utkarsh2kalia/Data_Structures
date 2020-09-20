package Trees;

import org.w3c.dom.Node;

public class InorderTraversal {
    public static void inordertraversal(TreeNode root){
        if (root == null)
            return;
        inordertraversal(root.left);
        System.out.print(root.data+" ");

        inordertraversal(root.right);
    }
    public static TreeNode insert(TreeNode root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new TreeNode(key);
        }

        // if given key is less than the root node,
        // recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        // else recur for right subtree
        else {
            // key >= root.data
            root.right = insert(root.right, key);
        }

        return root;
    }
    public static TreeNode maketree(int arr[]){
        TreeNode root = new TreeNode();
        for(int ele: arr) {
            root = insert(root, ele);
        }
        return root;
    }
    public static void main(String[] args) {
        int keys[] = {1,2,3,4,5,6,7,8};

        inordertraversal(maketree(keys));
    }
}
