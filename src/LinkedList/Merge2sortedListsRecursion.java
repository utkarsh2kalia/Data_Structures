package LinkedList;

import static LinkedList.LinkedList.makelist;
import static LinkedList.LinkedList.printAllNodes;

public class Merge2sortedListsRecursion {
    public static Node mergelistsrecursively(Node list1, Node list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        Node result;
        if (list1.data < list2.data) {
            result = list1;
            result.next = mergelistsrecursively(list1.next, list2);

        } else {
            result = list2;
            result.next = mergelistsrecursively(list1, list2.next);
        }
        return result;
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 7, 8, 11, 15};
        int brr[] = {2, 4, 5, 5, 6, 7, 8, 9, 10};
        Node list1 = makelist(arr);
        Node list2 = makelist(brr);
        printAllNodes(mergelistsrecursively(list1, list2));

    }
}