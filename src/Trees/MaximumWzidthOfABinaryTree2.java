package Trees;

import java.util.LinkedList;
import java.util.List;

import static Trees.InorderTraversal.maketree;
//Given a binary tree, write a function to get the maximum width of the given tree.
//        The maximum width of a tree is the maximum width among all levels.
//        The width of one level is defined as the length between the end-nodes
//        (the leftmost and right most non-null nodes in the level,
//        where the null nodes between the end-nodes are also counted into the length calculation.
//
//        It is guaranteed that the answer will in the range of 32-bit signed integer.
public class MaximumWzidthOfABinaryTree2 {
    private int max = 1;
    //like building a heap index for left and right children
    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        List<Integer> startOfLevel = new LinkedList<>();
        helper(root, 0, 1, startOfLevel);
        return max;
    }
    public void helper(TreeNode root, int level, int index, List<Integer> list) {
        if (root == null) return;
        // list contains the starting index of each level
        // we add index to list only when it is the starting index
        if (level == list.size()) list.add(index);
        max = Math.max(max, index + 1 - list.get(level));
//        System.out.println(max);
        helper(root.left, level + 1, index * 2, list);
        helper(root.right, level + 1, index * 2 + 1, list);
    }

    public static void  main(String[] args) {
        int arr[] = {4,3,2,6,5,7,1};
        MaximumWzidthOfABinaryTree2 obj = new MaximumWzidthOfABinaryTree2();
        System.out.println(obj.widthOfBinaryTree2(maketree(arr)));
    }
}
