package Trees;

import java.util.Stack;

import static Trees.InorderTraversal.maketree;

public class InorderTraversalIterative {
    public static void inordertraversaliterative(TreeNode root){

        // create a stack of type treenode
        Stack<TreeNode> stack = new Stack<>();

        // start from the root node
        TreeNode curr = root;

        while(!stack.isEmpty() || curr!=null){

            // if the current node is not null, push it into the stack and move to its left child
            // we are pushing it into stack so that we can print the data of the stack and move
            // to its right
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                curr = stack.pop();
                System.out.print(curr.data+" ");
                curr = curr.right;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {6,2,7,4,5,6,7,3,9};
        inordertraversaliterative(maketree(arr));
    }
}
