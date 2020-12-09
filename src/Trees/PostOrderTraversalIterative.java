package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) return ans;
        // in stack we add data that needs to be popped ou last first
        stack.push(root);
        while(!stack.isEmpty()) {
            // remove the node
            TreeNode node = stack.pop();
            // add the node at first, as it is post order, so root needs to be at last
            ans.addFirst(node.data);
            if(node.left != null) {
                stack.push(node.left);
            }
            //
            if(node.right != null) {
                stack.push(node.right);
            }
        }

        return ans;
    }

    // alternative method can be to add a new
}
