package Trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import static Trees.InorderTraversal.maketree;

public class ZigZagOrderTraversal {
    public static void zigzagtraversal(TreeNode root){

        Deque<TreeNode> qi = new ArrayDeque<>();
        if(root == null)
            return;
            qi.addFirst(root);
            boolean reverse = false; // reverse true means right to left
         while (!qi.isEmpty()){
             int count = qi.size();

             if(reverse)
             {
                 //right to left

                 for(int i = 0; i<count; i++){
                     TreeNode curr = qi.pollFirst();
                     if(curr!=null){
                     System.out.print(curr.data+" ");}
                     if(curr.left!=null)
                     qi.addLast(curr.left);
                     if(curr.right!=null)
                     qi.addLast(curr.right);
                 }
             }
             else{

                 for(int i = 0; i<count; i++)
                 {
                     // left to right
                     TreeNode curr = qi.pollLast();
                     System.out.print(curr.data+" ");
                     if(curr.left!=null)
                     qi.addFirst(curr.right);
                     if(curr.right!=null)
                     qi.addFirst(curr.left);
                 }

             }
             reverse = !reverse;
             System.out.println();


         }



    }

    public static void main(String[] args) {
        int arr[] = {4,3,2,6,5,7,1};
        zigzagtraversal(maketree(arr));
    }
}
