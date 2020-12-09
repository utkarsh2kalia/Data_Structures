package Trees;

import java.util.LinkedList;
import java.util.List;
//Given a binary tree, return all root-to-leaf paths.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
public class AllPaths {
    public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {

        if(root == null)
            return;
        path+=Integer.toString(root.data);
        if(root.right == null && root.left == null)
        {paths.add(path);
            return;}
        construct_paths(root.left, path+"->", paths);
        construct_paths(root.right, path+"->", paths);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        construct_paths(root, "", paths);
        return paths;
    }
}
