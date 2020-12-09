package Trees;

public class MaximumPathSum {
//    Given a non-empty binary tree, find the maximum path sum.
//        For this problem, a path is defined as any node sequence from some starting node to any node
//    in the tree along the parent-child connections. The path must contain at least one node and does not
//    need to go through the root.
//    Input: root = [-10,9,20,null,null,15,7]
//    Output: 42

int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxpath(root);
        return max;

    }

    public int maxpath(TreeNode  node)
    {
        if(node == null)
            return 0;

        int left_gain = Math.max(maxpath(node.left), 0);
        int right_gain = Math.max(maxpath(node.right), 0);
        int curr = node.data+left_gain+right_gain ;
        max = Math.max(max,curr);
        return node.data + Math.max(left_gain, right_gain);
    }

}
