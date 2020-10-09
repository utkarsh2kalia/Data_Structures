package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Trees.InorderTraversal.maketree;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelorder(TreeNode root){
        Queue<TreeNode> qi = new LinkedList<>();
        List<List<Integer>> biglist = new LinkedList<>();
        if(root == null)
            return biglist;
        qi.add(root);

        while(!qi.isEmpty()){
            int count = qi.size();
            List<Integer> list = new LinkedList<>();
            for(int i =0; i<count; i++){
                // take the front element out
                TreeNode curr = qi.poll();
                // add the data to list
                list.add(curr.data);
                if(curr.left!=null)
                    qi.add(curr.left);
                if(curr.right!=null)
                    qi.add(curr.right);
            }
            biglist.add(list);
        }
        return biglist;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,23,2,42,4,33,24,12,4,2};
        System.out.println(levelorder(maketree(arr)));
    }
}
