package InterviewBit.LinkedList;

public class KthNodeFromMiddle {
//    Given a linked list A of length N and an integer B.
//
//You need to find the value of the Bth node from the middle towards the beginning of the Linked List A.
//
//If no such element exists, then return -1.
//
//NOTE:
public int solve(ListNode A, int k) {
    ListNode curr = A;
    int i = 0;

    // otherwise curr points to the kth element
    ListNode slow = A;
    ListNode fast = A;

    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
        if(i>= k && curr!=null){
            curr = curr.next;
            i++;
        }
        else
            i++;


    }
    if(curr==null || i<k)
        return -1;
    return curr.val;

}
}
