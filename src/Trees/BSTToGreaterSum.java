package Trees;
//Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//        Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
public class BSTToGreaterSum {
    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.data = pre + root.data;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
