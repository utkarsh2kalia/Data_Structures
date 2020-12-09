package Trees;

import java.util.HashMap;
import java.util.Map;
//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//        Note:
//        You may assume that duplicates do not exist in the tree.
//
//        For example, given
//
//        inorder = [9,3,15,20,7]
//        postorder = [9,15,7,20,3]
public class BinaryTreeFromInorderAndPreorder {
    Map<Integer, Integer> indexMap = new HashMap<>();
    int[] preorder;
    int[] inorder;
    int prix;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0) return null;
        for(int i=0; i<inorder.length; i++){
            indexMap.put(inorder[i], i);
        }
        prix = 0;
        this.preorder =preorder;
        return build(0, preorder.length-1);
    }


    private TreeNode build(int start, int end){
        if(start > end) return null;
        // store the root value from postfix
        int val = preorder[prix];
        // create a node
        TreeNode node = new TreeNode(val);
        // get the index of the root in inorder, it will serve as the partition point
        int index = indexMap.get(val);
        // System.out.println(node.val);
        prix++;
        node.left = build(start, index-1);
        node.right = build(index+1, end);

        return node;
    }
}
