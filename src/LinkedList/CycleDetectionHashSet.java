package LinkedList;

import java.util.HashSet;
import java.util.Set;

import static LinkedList.LinkedList.makelist;

public class CycleDetectionHashSet {
    public static Node detectCycle(Node head) {

        if(head == null || head.next==null)
            return null;
        Set<Node> nodes = new HashSet();
        while(head!=null)
        {
            if(!nodes.contains(head))
                nodes.add(head);
            else
                return head;
            head = head.next;

        }

        return null;
    }
    public static void main(String[] args) {
        int arr [] = {1,2,3,4,6, 7, 8};
        Node head = makelist(arr);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head).data);
    }
}
