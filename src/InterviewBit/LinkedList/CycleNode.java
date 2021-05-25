package InterviewBit.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class CycleNode {
//    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//Try solving it using constant additional space.
public ListNode detectCycle(ListNode head) {

    if(head == null || head.next==null)
        return null;
    Set<ListNode> nodes = new HashSet();
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
}
