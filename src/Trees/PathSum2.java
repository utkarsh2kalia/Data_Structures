package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
//    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//   Note: A leaf is a node with no children. Example:
//Given the below binary tree and sum = 22, O(n)
//
//            5
//            / \
//            4   8
//            /   / \
//            11  13  4
//            /  \    / \
//            7    2  5   1
//    Return:[
//            [5,4,11,2],
//            [5,8,4,5]
//            ]

    List<List<Integer>> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return list;
        pathsum(new ArrayList<>(), root, sum);
        return list;


    }
    void pathsum(List<Integer> temp, TreeNode root, int sum)
    {
        if(root == null)return;

        temp.add(root.data);
        if(root.left == null && root.right == null && sum - root.data == 0)
        {list.add(new ArrayList<>(temp));
            // return;
        }

        pathsum(temp,root.left, sum - root.data);
        pathsum(temp, root.right, sum - root.data);
        temp.remove(temp.size() - 1);


    }
}
