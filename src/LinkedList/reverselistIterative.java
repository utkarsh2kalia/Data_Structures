package LinkedList;

import static LinkedList.LinkedList.makelist;
import static LinkedList.LinkedList.printAllNodes;

public class reverselistIterative {
    public static Node reverseListIter(Node head)
    {
        if(head == null)
            return head;
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            // store the address of the next node
            Node next = curr.next;
            //make the next node pint to prev
            curr.next = prev;
            // make prev point to prev
            prev = curr;
            // take current to next node
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        Node head = makelist(arr);
        printAllNodes(reverseListIter(head));
    }
}
