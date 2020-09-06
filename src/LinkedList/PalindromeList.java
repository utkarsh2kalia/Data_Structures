package LinkedList;

import static LinkedList.LinkedList.makelist;

public class PalindromeList {

    public static boolean ispalin(Node head)
    {
        // find the middle element in list
        Node fast = head, slow = head;
        while(fast != null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) {
            // means odd nodes
            slow = slow.next;
        }
        slow = ReverseLinkedList.reverseList(slow, null, slow);
        fast = head;
        while(slow!=null)
        {
            if(slow.data != fast.data){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;

    }

    public static void main(String[] args) {
        int arr[] = {1,4,4,1,4,4,1};
        Node head = makelist(arr);
        System.out.println(ispalin(head));

    }
}
