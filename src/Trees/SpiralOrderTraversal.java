package Trees;

import java.util.*;

import static Trees.InorderTraversal.maketree;

public class SpiralOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            /* use linkedlist to control time complexity of addFirst to O(1) */
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (reverse) {
                    tempList.addFirst(curNode.data);
                } else {
                    tempList.add(curNode.data);
                }

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            result.add(tempList);
            reverse = !reverse;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {3,9,20,1,5,15,7};
        System.out.println(zigzagLevelOrder(maketree(arr)));
    }
}
