package Trees;

import java.util.*;

//We are given a binary tree (with root node root), a target node, and an integer value K.
//Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
// Example 1:
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//Output: [7,4,1]
//Explanation:
//The nodes that are a distance 2 from the target node (with value 5)
//have values 7, 4, and 1.
//Note that the inputs "root" and "target" are actually TreeNodes.
//The descriptions of the inputs above are just serializations of these objects.
public class    AllNodesDistanceKinBinaryTree1 {


    Map<TreeNode, TreeNode> map;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        map = new HashMap<>();
        dfs(root, null);

        // used to check if the node is seen before or not. it is useful mostly while moving upwards
        Set<TreeNode> seen = new HashSet<>();
//         used to store the result
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(target);
        seen.add(target);
        int dist = 0;
// now we need to perform bfs starting from the target node
        // we will be performing level order upwards as well as downwards
        while (!qu.isEmpty()) {

            // check if diatance is k
            if (dist == K) {
                // add all the nodes in the list
                for (TreeNode node : qu) {
                    list.add(node.data);
                }
                return list;


            }
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();
                // add it to the set
                seen.add(node);
                // add left and the right child
                if (node.left != null && !seen.contains(node.left)) {
                    qu.offer(node.left);
                    seen.add(node.left);
                }
                if (node.right != null && !seen.contains(node.right)) {
                    qu.offer(node.right);
                    seen.add(node.right);
                }
                // add the parents
                TreeNode par = map.get(node);
                if (par != null && !seen.contains(par)) {
                    qu.offer(par);
                    seen.add(par);
                }
            }
            dist++;
        }
        return list;


    }

    // this function is used to store the parent of all the node in a hashmap using dfs
    public void dfs(TreeNode node, TreeNode par) {

        if (node != null) {
            map.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }


    }
}
