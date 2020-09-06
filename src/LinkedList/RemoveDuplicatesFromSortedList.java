package LinkedList;

import static LinkedList.LinkedList.makelist;
import static LinkedList.LinkedList.printAllNodes;

public class RemoveDuplicatesFromSortedList {
    public static Node removeduplicates(Node head){
        if(head == null){
            return head;
        }
        Node curr = head;
        while(curr.next != null){
            if(curr.data == curr.next.data){
                Node nextnode = curr.next.next;
                curr.next = nextnode;
            }
            else
                curr = curr.next;

        }
        return head;

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,3,3,4,5,5};
        Node head = removeduplicates(makelist(arr));

        printAllNodes(head);
    }
}
