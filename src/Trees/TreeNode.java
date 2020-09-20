package Trees;

import com.sun.source.tree.Tree;

public class TreeNode {
    TreeNode left, right;
    int data;
    TreeNode(int data){
        this.data = data;
    }
    TreeNode(){
        left  = null;
        right = null;
    }

}
