package InterviewBit.LinkedList;

public class RemoveNthNodeFromEnd {
//    Given a linked list, remove the nth node from the end of list and return its head.
//
//For example,
//Given linked list: 1->2->3->4->5, and n = 2.
//After removing the second node from the end, the linked list becomes 1->2->3->5.
public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null)
        return head;
    ListNode curr = head;
    ListNode prev = null;
    ListNode dummy  = head;

    for( int i=0;i<n && dummy!=null;i++){
        dummy = dummy.next;
    }
    while(dummy!=null){
        prev = curr;
        curr = curr.next;
        dummy = dummy.next;

    }
    if(prev == null)
        return head.next;
    else
        prev.next = curr.next;
    return head;
}
}
