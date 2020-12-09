package Trees;

import java.util.HashMap;

//You are given a binary tree in which each node contains an integer value.
//        Find the number of paths that sum to a given value.
//        The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
//        The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
//        Example:
//        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//        10
//        /  \
//        5   -3
//        / \    \
//        3   2   11
//        / \   \
//        3  -2   1
//        Return 3. The paths that sum to 8 are:
//        1.  5 -> 3
//        2.  5 -> 2 -> 1
//        3. -3 -> 11
public class SumPath3usingPrefixSum {
    int count = 0;
    int k;
    HashMap<Integer, Integer> map = new HashMap();

    public void preorder(TreeNode node, int currSum) {
        if (node == null)
            return;

        // current prefix sum
        currSum += node.data;

        // here is the sum we're looking for
        if (currSum == k)
            count++;

        // number of times the curr_sum − k has occured already,
        // determines the number of times a path with sum k
        // has occured upto the current node
        count += map.getOrDefault(currSum - k, 0);

        // add the current sum into hashmap
        // to use it during the child nodes processing
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // process left subtree
        preorder(node.left, currSum);
        // process right subtree
        preorder(node.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during
        // the parallel subtree processing
        map.put(currSum, map.get(currSum) - 1);
    }

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }

    public static void main(String[] args) {

    }
}
