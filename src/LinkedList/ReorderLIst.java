package LinkedList;
//Share
//        Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//        reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//        You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//        Example 1:
//
//        Given 1->2->3->4, reorder it to 1->4->2->3.
//        Example 2:
//
//        Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
public class ReorderLIst {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. reverse the 2nd half
        ListNode l2 = reverse(slow);

        // step 3. merge the two halves
        merge(l1, l2);
        return head;
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }




    public static void main(String[] args) {
        int []arr= {1,2,3,4,5,6,7};

        ListNode.printAllNodes(reorderList(ListNode.makeList(arr)));
    }

}
