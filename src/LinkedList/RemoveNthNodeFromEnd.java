package LinkedList;

import static LinkedList.LinkedList.makelist;
import static LinkedList.LinkedList.printAllNodes;

public class RemoveNthNodeFromEnd {
    public static Node removenthnodefromend(Node head, int n){
        if(head == null)
            return head;
        Node dummy  = head;
        Node curr = head;

        for (int i = 1; i<=n && dummy!=null; i++){
            dummy = dummy.next;
        }


        Node prev = null; // to move behind curr to help in removing the curr node
        // loop to take dummy to the end and curr to nth node
        while(dummy != null ){
            prev = curr;
            curr = curr.next;
            dummy = dummy.next;
        }
        if(prev == null)
            head= head.next; // means the first node needs to be removed
        else
        prev.next = curr.next; // remove the nth node;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = {1,2, 3, 4, 5};
        Node head = makelist(arr);
        printAllNodes(removenthnodefromend(head, 5));
    }
}
