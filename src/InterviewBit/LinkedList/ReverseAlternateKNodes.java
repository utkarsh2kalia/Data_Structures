package InterviewBit.LinkedList;
//Given a linked list A of length N and an integer B.
//
//You need to reverse every alternate B nodes in the linked list A.
//A = 3 -> 4 -> 7 -> 5 -> 6 -> 6 -> 15 -> 61 -> 16
//        B = 3
//7 -> 4 -> 3 -> 5 -> 6 -> 6 -> 16 -> 61 -> 15
public class ReverseAlternateKNodes {
    public ListNode solve(ListNode node, int k) {

        ListNode curr = node;
        ListNode next = null, prev = null;

        int count = 0;
        while(curr!=null && count<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(node!=null)
            node.next = curr;
        count = 0;


        while (count < k - 1 && curr != null) {
            curr = curr.next;
            count++;
        }

        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if (curr != null) {
            curr.next = solve(curr.next, k);
        }

        /* 5) prev is new head of the input list */
        return prev;





    }
}
