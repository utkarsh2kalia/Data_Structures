package LinkedList;

import static LinkedList.LinkedList.makelist;
import static LinkedList.LinkedList.printAllNodes;

public class MergeSortLinkedList {

    public static Node merge(Node l1, Node l2){
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Node head = new Node(-1);
        Node prev = head;
        while(l1!= null && l2!=null){
            if(l1.data<l2.data)
            {
                prev.next = l1;
                l1 = l1.next;
            }
            else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1==null && l2!=null)
            prev.next = l2;
        else if(l2 == null && l1!=null)
            prev.next = l1;

        return head.next;
    }
    public static Node getmid(Node head){
        Node midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    // function to divide the list
    public static Node sortlist(Node head){
        if(head == null || head.next == null)
            return head;
        // find mid
        Node mid = getmid(head);
        Node left = sortlist(head);
        Node right = sortlist(mid);
        return merge(left, right);

    }
public static void main(String[] args) {
//    System.out.println("s");
    int arr[] = {2,4,1,435,2,3,1,543,757,3,4324,2,241,22};

    printAllNodes(sortlist(makelist(arr)));
}
}
