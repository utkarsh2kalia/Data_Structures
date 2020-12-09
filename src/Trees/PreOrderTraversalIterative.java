package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root==null) return preorder;
        // create a stack
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            preorder.add(node.data);
            if(node.right!=null) st.push(node.right);
            if(node.left!=null) st.push(node.left);
        }

        return preorder;
    }
}
