package LinkedList;

import static LinkedList.LinkedList.makelist;

public class FloydCycleDetection {
    public static boolean  detectcycle(Node head)
    {
        Node slow = head;
        Node fast =  head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,3,4,6};
        Node head = makelist(arr);
        head.next.next.next.next = head;
        System.out.println(detectcycle(head));
    }
}
