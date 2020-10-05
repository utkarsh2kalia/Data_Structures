package LinkedList;

//
//Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.
//
//        We can merge two sorted linked list in O(n) time where nn is the total number of nodes in two lists.
//        Sum up the merge process and we can get: O\big(\sum_{i=1}^{log_{2}{k}}N \big)= O(N\log k)O(∑
//
//        N)=O(Nlogk)
//        Space complexity : O(1)
//We can merge two sorted linked lists in O(1)O(1) space.
import static LinkedList.LinkedList.makelist;
import static LinkedList.LinkedList.printAllNodes;
public class MergeKsortedLinkedlists {

    // a function to merge 2 lists
    public static Node mergelists(Node list1, Node list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        // create a dummy node
        Node head = new Node(-1);
        Node prev = head;
        while(list1!=null && list2!=null){
            if(list1.data<  list2.data) {
                prev.next = list1;
                list1 = list1.next;
            }
            else
            {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;

        }
        if (list1==null && list2!=null)
            prev.next = list2;
        else
            prev.next = list1;

        return head.next;
    }

    // function to merge k lists
    public static Node mergeKlists(Node[]lists){
        if(lists.length == 0)
            return null;
        int interval = 1;
        while(interval<lists.length){
            for(int i = 0; i+interval<lists.length; i=i+interval*2){
                lists[i] = mergelists(lists[i], lists[i+interval]);
            }
            interval = interval*2;
        }
        return lists[0];

    }


    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,7,8,};
        int arr2[] = {4,5,6,7,8,9};
        int arr3[] = {4,5,6,7};
        Node lists[] = {makelist(arr1), makelist(arr2), makelist(arr3)};
        printAllNodes(mergeKlists(lists));
    }
}
