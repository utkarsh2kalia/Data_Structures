package Trees;
//Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
//
//Return the number of good nodes in the binary tree.
//Example 1:
//Input: root = [3,1,4,3,null,1,5]
//Output: 4
//Explanation: Nodes in blue are good.
//Root Node (3) is always a good node.
//Node 4 -> (3,4) is the maximum value in the path starting from the root.
//Node 5 -> (3,4,5) is the maximum value in the path
//Node 3 -> (3,1,3) is the maximum value in the path.
public class GoodNodesInTree {
    public int goodNodes(TreeNode root) {
        return countNodes(root, Integer.MIN_VALUE);
    }

    public int countNodes(TreeNode root, int max)
    {
        if(root == null)
            return 0;

        int res = (root.data>=max)?1:0;
        max = Math.max(root.data, max);

        res+=countNodes(root.left, max);
        res+=countNodes(root.right, max);

        return res;

    }
}
