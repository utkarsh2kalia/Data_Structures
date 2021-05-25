package InterviewBit.LinkedList;
//Merge two sorted linked lists and return it as a new list.
//The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.
//
//For example, given following linked lists :
//
//  5 -> 8 -> 20
//  4 -> 11 -> 15
//The merged list should be :
//
//4 -> 5 -> 8 -> 11 -> 15 -> 20
public class Merge2SortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode dummy = new ListNode(-100);
        ListNode tail = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                tail.next = list1;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1!=null)
            tail.next = list1;
        else if(list2!=null)
            tail.next = list2;

        return dummy.next;
    }

}
