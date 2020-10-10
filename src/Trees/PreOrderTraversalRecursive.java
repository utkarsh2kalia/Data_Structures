package Trees;

import java.util.ArrayList;
import java.util.List;

import static Trees.InorderTraversal.maketree;

public class PreOrderTraversalRecursive {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root != null)
        {
            list.add(root.data);
            preorderTraversal(root.left);


            preorderTraversal(root.right);

            return list;
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,23,2,42,4,33,24,12,4,2};
        PreOrderTraversalRecursive obj = new PreOrderTraversalRecursive();
        System.out.println(obj.preorderTraversal(maketree(arr)));
//        int arr[] =arr {2,3,4,23,2,42,4,33,24,12,4,2};
        LevelOrderTraversalBottomUp1 obj1 = new LevelOrderTraversalBottomUp1();
        System.out.println(obj1.levelOrderBottom(maketree(arr)));
    }
}
