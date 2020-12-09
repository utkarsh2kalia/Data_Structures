package LinkedList;

public class ReverseAlternateKNodes {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */

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


