package LinkedList;

import Trees.LevelOrderTraversal;
import Trees.TreeNode;

public class SortedLinkedListtoBST {

    public static TreeNode linkedlisttoBST(ListNode head)
    {

        TreeNode root = generateBST(head, null);
        return root;
    }
    public static TreeNode generateBST(ListNode head, ListNode tail){
        if(head == tail)
            return null;
        // find the mid node
        ListNode mid = getmid(head, tail);
        // create new node with the value
        TreeNode thead = new TreeNode(mid.val);
        thead.left = generateBST(head, mid);
        thead.right = generateBST(mid.next, tail);
        return thead;
    }
    public static ListNode getmid(ListNode head, ListNode tail){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= tail && fast.next!=tail)
        {
            slow =slow.next;
            fast =fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int arr[] = {-10,-3,0,5,9};
        TreeNode root = linkedlisttoBST(ListNode.makeList(arr));

        System.out.println(LevelOrderTraversal.levelorder(root));
    }

}
