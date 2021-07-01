package Trees;

public class MinimumDepthOfBinaryTree {

    // move towards left till we reach the last node. after reaching the last node, , 1 is returned. now we go right and check
    public int minimumDepth(TreeNode root){

        if(root == null)
        return 0;

        if(root.left == null && root.right == null)
            return 1;
        int minDepth = Integer.MAX_VALUE;
        //
        if(root.left!=null)
        {
            minDepth = Math.min(minimumDepth(root.left), minDepth);
        }
        if(root.right!=null){
            minDepth = Math.min(minimumDepth(root.right), minDepth);
        }
    
        return minDepth+1;

    }



}
