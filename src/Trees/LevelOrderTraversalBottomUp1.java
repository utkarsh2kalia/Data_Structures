package Trees;

import java.util.ArrayList;
import java.util.List;

import static Trees.InorderTraversal.maketree;

// This performs level order traversal using DFS
public class LevelOrderTraversalBottomUp1 {


        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            levelOrderBottom(result, root, 0);
            return result;
        }

        public void levelOrderBottom(List<List<Integer>> result, TreeNode root, int level) {
            if (root == null) {
                return;
            }
            //a list will be added on reaching each level on the first time
            if (result.size() <= level) {
                result.add(0, new ArrayList<>());
            }
            // perform post order traversal
            levelOrderBottom(result, root.left, level + 1);
            levelOrderBottom(result, root.right, level + 1);

            result.get(result.size() - level - 1).add(root.data);

        }

    public static void main(String[] args) {
        int arr[] = {2,3,4,23,2,42,4,33,24,12,4,2};
        LevelOrderTraversalBottomUp1 obj = new LevelOrderTraversalBottomUp1();
        System.out.println(obj.levelOrderBottom(maketree(arr)));
    }
    }


