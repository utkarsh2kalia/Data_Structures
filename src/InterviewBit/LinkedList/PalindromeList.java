package InterviewBit.LinkedList;
//Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

class ListNode {
     public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
 }
public class PalindromeList {

    public ListNode reverseList(ListNode curr, ListNode prev, ListNode head){
        if(curr == null)
        {
            head = prev;
            return head;
        }

        head = reverseList(curr.next, curr, head);
        curr.next = prev;
        return head;
    }
    public int lPalin(ListNode A) {
        ListNode slow = A, fast = A;

        // find the middle element
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if( fast != null){
            // means odd elements
            slow = slow.next;
        }
        // reverse the linked list
        fast = A;
        slow = reverseList(slow, null, slow);
        while(slow!=null){
            if(slow.val != fast.val)
            {
                return 0;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return 1;
    }
}
