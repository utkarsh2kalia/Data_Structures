package Trees;

import java.util.HashMap;
import java.util.Map;
 class Node1{
    int val;
    Node1 random ;
    Node1 left, right;
    Node1(int val)
    {
        this.val = val;

    }

}

class NodeCopy{
    int val;
    NodeCopy random ;
    NodeCopy left, right;
    NodeCopy(int val)
    {
        this.val = val;

    }

}

//A binary tree is given such that each node contains an additional random pointer which could point to any node in the tree or null.
//
//        Return a deep copy of the tree.
//
//        The tree is represented in the same input/output way as normal binary
//        trees where each node is represented as a pair of [val, random_index] where:
//
//        val: an integer representing Node.val
//        random_index: the index of the node (in the input) where the random pointer points to, or null if it does not point to any node.
public class CloneBinaryTreeWithRandomPointers {

    public NodeCopy copyRandomBinaryTree(Node1 root) {
        Map<Node1,NodeCopy> map = new HashMap<>();
        return dfs(root, map);
    }

    public NodeCopy dfs(Node1 root, Map<Node1,NodeCopy> map){
        if (root==null) return null;

        if (map.containsKey(root)) return map.get(root);

        NodeCopy newNode = new NodeCopy(root.val);
        map.put(root,newNode);

        newNode.left=dfs(root.left,map);
        newNode.right=dfs(root.right,map);
        newNode.random=dfs(root.random,map);

        return newNode;

    }
}
