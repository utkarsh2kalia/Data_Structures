package Trees;

import java.util.*;
import Trees.TreeNode;

import static Trees.InorderTraversal.maketree;

//Given a binary tree, return the vertical order traversal of its nodes values.
//For each node at position (X, Y), its left and right children respectively will be at
// positions (X-1, Y-1) and (X+1, Y-1).
//Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
// we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
//If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
//Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
//Input: [3,9,20,null,null,15,7]
//Output: [[9],[3,15],[20],[7]]
public class VerticalOrderTraversal {
    static int leftMost = 0;
    static int rightMost = 0;

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, PriorityQueue<Pair>> treeMap = new HashMap<>();
        verticalTraversal(root, 0, treeMap, 0);
        for (int k = leftMost; k <= rightMost; k++) {
            List<Integer> temp = new ArrayList<>();
            while (!treeMap.get(k).isEmpty()) {
                temp.add(treeMap.get(k).poll().node.data);
            }
            result.add(temp);
        }
        return result;
    }

    static void verticalTraversal(TreeNode root, int col, Map<Integer, PriorityQueue<Pair>> treeMap, int level) {
        if (root == null) return;
        leftMost = Math.min(leftMost, col);
        rightMost = Math.max(rightMost, col);
        treeMap.putIfAbsent(col, new PriorityQueue<>((a, b) -> {
            int diff = a.level - b.level;
            return diff != 0 ? diff : a.node.data - b.node.data;
        }));
        treeMap.get(col).add(new Pair(root, level));
        verticalTraversal(root.left, col - 1, treeMap, level + 1);
        verticalTraversal(root.right, col + 1, treeMap, level + 1);
    }

    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,9,20, 15,7};
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);
        root.left.right.right = new TreeNode(45);
        System.out.println(verticalTraversal(root));
    }
}