package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static Trees.InorderTraversal.maketree;
import static Trees.LevelOrderTraversal.levelorder;

public class MaximumWidthOfABinaryTree {
    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> m = new HashMap<TreeNode, Integer>();
        q.offer(root);
        m.put(root, 1);
        int curW = 0;
        int maxW = 0;
        while(!q.isEmpty()){
            // store the number of nodes in each level
            int size = q.size();
            int start = 0;
            int end = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                // get the starting index of each node
                if(i == 0) start = m.get(node);
                // ending index of eaxh node
                if(i == size - 1) end = m.get(node);
                // if a left node is present, its position should be 2*i
                if(node.left != null){
                    m.put(node.left, m.get(node) * 2);
                    q.offer(node.left);
                }
                //if a right node is present, its position will be 2*i +1
                if(node.right != null){
                    m.put(node.right, m.get(node) * 2 + 1);
                    q.offer(node.right);
                }
            }
            //width of current level
            curW = end - start + 1;
            // max width is the maximum of the current width and the previous maximum
            maxW = Math.max(curW, maxW);
        }
        return maxW;
    }

    public static void main(String[] args) {
        int arr[] = {16, 26, 27,11, 33,100,63,45};
        TreeNode root = maketree(arr);
        System.out.println(levelorder(root));
        System.out.println(widthOfBinaryTree(root));
    }
}
