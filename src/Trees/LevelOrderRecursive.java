package Trees;

import java.util.ArrayList;
import java.util.List;

import static Trees.InorderTraversal.maketree;

public class LevelOrderRecursive {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(result, root, 0);
        return result;
    }

    public void levelOrder(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        //a list will be added on reaching each level on the first time
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        // perform post order traversal
        levelOrder(result, root.left, level + 1);
        levelOrder(result, root.right, level + 1);

        result.get(level).add(root.data);

    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,23,2,42,4,33,24,12,4,2};
        LevelOrderRecursive obj = new LevelOrderRecursive();
        System.out.println(obj.levelOrder(maketree(arr)));
    }
}
