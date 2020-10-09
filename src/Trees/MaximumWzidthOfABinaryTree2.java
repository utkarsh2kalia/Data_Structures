package Trees;

import java.util.LinkedList;
import java.util.List;

import static Trees.InorderTraversal.maketree;

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
        helper(root.left, level + 1, index * 2, list);
        helper(root.right, level + 1, index * 2 + 1, list);
    }

    public static void main(String[] args) {
        int arr[] = {4,3,2,6,5,7,1};
        MaximumWzidthOfABinaryTree2 obj = new MaximumWzidthOfABinaryTree2();
        System.out.println(obj.widthOfBinaryTree2(maketree(arr)));
    }
}
