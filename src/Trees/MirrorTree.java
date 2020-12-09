package Trees;
//Given  a tree check if it is a mirror tree in which the left and right subtree are mirror images;
//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
// Same as symmetric tree
public class MirrorTree {
    public boolean isSymmetric(TreeNode root) {

        return isMirror(root, root);

    }
    public boolean isMirror(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.data != root2.data)
            return false;
        return (isMirror(root1.left, root2.right)  &&
                isMirror(root1.right, root2.left));

    }

    public static void main(String[] args) {

    }
}
