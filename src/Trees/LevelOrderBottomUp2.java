package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottomUp2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.data);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            // add to the first
            list.add(0, tmp);
        }
        return list;
    }
}
