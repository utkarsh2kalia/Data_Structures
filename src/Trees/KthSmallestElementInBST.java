package Trees;

import java.util.Stack;

public class KthSmallestElementInBST {
    // idea is to iterate in inorder, the kth element is the smallest one
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }
        return root.data;
    }
}
