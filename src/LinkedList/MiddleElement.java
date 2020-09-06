package LinkedList;

import static LinkedList.LinkedList.makelist;

public class MiddleElement {
    public static Node midElement(Node head)
    {
        if(head == null || head.next==null)
            return head;
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null)
            ;//means odd nodes

        return slow;

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        Node head = makelist(arr);
        System.out.println(midElement(head).data);
    }
}
