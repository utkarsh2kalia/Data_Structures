package LinkedList;

//Reverse a linked list from position m to n. Do it in one-pass.
//
//Note: 1 ≤ m ≤ n ≤ length of list.
//
//Example:
//
//Input: 1->2->3->4->5->NULL, m = 2, n = 4
//Output: 1->4->3->2->5->NULL

public class ReverseListFromMtoN {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode curr = head, prev = null;
        while(m>1){
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        // save the prev value in con to make it point to next
        ListNode con = prev, tail = curr;
        ListNode third;
        //ListNode next = null;
        while(n>0){
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            n--;
        }

        if(con!=null){
            con.next = prev;
        }
        else
            head = prev;

        tail.next = curr;
        return head;





    }
}
