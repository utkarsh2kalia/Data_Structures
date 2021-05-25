package InterviewBit.LinkedList;

public class RemoveDuplicatesFromLL {

//    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.
public ListNode deleteDuplicates(ListNode head) {
    if(head == null)
        return head;

    ListNode dummy = new ListNode(-100);

    ListNode curr = head;
    ListNode prev = dummy;
    dummy.next = head;

    while(curr!=null){
        // keep moving if prev.next is equla to curr. next
        while(curr.next!=null && curr.next.val == prev.next.val)
            curr = curr.next;

        if(prev.next == curr)
            prev = prev.next;

        else
            prev.next = curr.next;

        curr = curr.next;
    }
    return dummy.next;
}
}
