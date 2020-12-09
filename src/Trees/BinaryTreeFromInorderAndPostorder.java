package Trees;
import java.util.HashMap;
import java.util.Map;

import Trees.TreeNode;
//

//
//import java.util.ArrayDeque;
//import java.util.Deque;
////
//////post order traversal consists of the root at the end
////// we need to find the index of the root in the inorder traversal, so that we can divide it into 2 parts
//////1. the left subtree
//////2. the right subtree
////// eg
public class BinaryTreeFromInorderAndPostorder {
    Map<Integer, Integer> indexMap = new HashMap<>();
    int[] postorder;
    int[] inorder;
    int posix;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) return null;
        for(int i=0; i<inorder.length; i++){
            indexMap.put(inorder[i], i);
        }
        posix = inorder.length-1;
        this.postorder = postorder;
        return build(0, postorder.length-1);
    }


    private TreeNode build(int start, int end){
        if(start > end) return null;
        // store the root value from postfix
        int val = postorder[posix];
        // create a node
        TreeNode node = new TreeNode(val);
        // get the index of the root in inorder, it will serve as the partition point
        int index = indexMap.get(val);
        // System.out.println(node.val);
        posix--;
        node.right = build(index+1, end);
        node.left = build(start, index-1);
        return node;
    }
}
