package InterviewBit.LinkedList;

public class ReverseKNodes {
//    Given a singly linked list and an integer K, reverses the nodes of the
//
//list K at a time and returns modified linked list.
//
// NOTE : The length of the list is divisible by K
//Example :
//
//Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
//
//You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
public ListNode reverseList(ListNode head, int k) {
    if(head == null)
        return null;

    int count = 0;
    ListNode curr = head, prev = null;
    while(curr != null && count++<k ){
        ListNode next = curr.next;
        curr.next = prev;
        prev  = curr;
        curr = next;
    }

    head.next = reverseList(curr, k);

    return prev;
}
// below solution is for leetcode
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null)
            return null;

        int count = 0;
        ListNode temp = head;
        while(temp!=null && count++<k){
            temp = temp.next;

        }
        if(temp == null && count!=k)
        {

            return head;
        }
        count = 0;
        ListNode curr = head, prev = null;
        while(curr != null && count++<k ){
            ListNode next = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = next;
        }


        head.next = reverseKGroup(curr, k);

        return prev;

    }
}
