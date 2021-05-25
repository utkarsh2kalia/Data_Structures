package LinkedList;

import static LinkedList.LinkedList.makelist;
import static LinkedList.LinkedList.printAllNodes;

public class MergeKsortedLinkedLists2 {
    public static Node mergeKLists(Node[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private static Node mergeKLists(Node[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];
        // divide and conquer
        int middle = (start + end) >> 1;
        Node leftList = mergeKLists(lists, start, middle);
        Node rightList = mergeKLists(lists, middle + 1, end);
        return merge2Lists(leftList, rightList);
    }

    private static Node merge2Lists(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.data < list2.data) {
            list1.next = merge2Lists(list1.next, list2);
            return list1;
        } else {
            list2.next = merge2Lists(list1, list2.next);
            return list2;
        }
    }
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,7,8,};
        int arr2[] = {4,5,6,7,8,9};
        int arr3[] = {4,5,6,7};
        Node lists[] = {makelist(arr1), makelist(arr2), makelist(arr3)};
        printAllNodes(mergeKLists(lists));
    }
}
