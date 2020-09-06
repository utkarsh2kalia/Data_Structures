package LinkedList;

import static LinkedList.LinkedList.makelist;
import static LinkedList.LinkedList.printAllNodes;

public class Merge2sortedListsIterative {
    public static Node merge2listsiterative(Node list1, Node list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null)
            return list1;
        Node dummy = new Node(-100);
        Node tail = dummy;
        while(list1!=null && list2 !=null){
            if(list1.data<list2.data) {
                tail.next = list1;
                // move list1 ahead
                list1 = list1.next;
            }
                else{
                tail.next = list2;
                // move list2 ahead
                list2 = list2.next;
                }
                // move tail ahead
            tail = tail.next;


            }
        if(list1 != null) {
            tail.next = list1;
        }
        else if(list2 != null){
            tail.next = list2;

        }
        return dummy.next;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 7, 8, 11, 15};
        int brr[] = {2, 4, 5, 5, 6, 7, 8, 9, 10};
        Node list1 = makelist(arr);
        Node list2 = makelist(brr);
        printAllNodes(merge2listsiterative(list1, list2));

    }
}
