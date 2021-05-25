package Trees;

import com.sun.source.tree.Tree;

import java.io.EOFException;
import java.io.IOException;

import static Trees.InorderTraversal.inordertraversal;
import static Trees.InorderTraversal.maketree;

//Given a binary tree and a sum, determine if the tree has a
//
// "root-to-leaf"
//
// path such that
// adding up all the values along the path equals the given sum.
// Note: A leaf is a node with no children.
//Example:
//Given the below binary tree and sum = 22,
//
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \      \
//        7    2      1
//        return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
public class BinaryTreePathSum{
    public static boolean sumpath(TreeNode root, int sum){
        if(root == null)
            return false;

        if(root.left == null && root.right == null && sum - root.data == 0)
            return true;


      return  sumpath(root.left, sum - root.data) || sumpath(root.right, sum - root.data);
    }


    public static void main(String[] args) {
        int arr[] = {5,4,8,11,13,4,7,2,1};
        TreeNode root = maketree(arr);
        System.out.println(root.data);
        inordertraversal(root);
        System.out.println(sumpath(root, 9));
    }
}
