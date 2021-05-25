package InterviewBit.LinkedList;

public class Add2NosAsList {

//    You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//
//    342 + 465 = 807
public ListNode addTwoNumbers(ListNode A, ListNode B) {
    ListNode dummy = new ListNode(0);
    ListNode p = A;
    ListNode q = B;
    ListNode curr = dummy;
    int carry = 0;
    while (p != null || q != null) {
        int a = (p != null) ? p.val : 0;
        int b = (q != null) ? q.val : 0;
        int sum = carry + a + b;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null)
            p = p.next;
        if (q != null)
            q = q.next;


    }
    if (carry > 0)
        curr.next = new ListNode(carry);
    return dummy.next;

}
}
