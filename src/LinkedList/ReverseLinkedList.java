package LinkedList;

import java.util.Scanner;

import static LinkedList.LinkedList.*;

//class Node {
//    int data;
//    Node next;
//    Node(int data){
//        this.data = data;
//        next = null;
//
//    }

//}
public class ReverseLinkedList {
    public static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static Node reverseList(Node curr, Node prev, Node head)
    {
        if(curr == null){
            // fix the head pointer
            head = prev;
            return head;
        }
        // recur for next and send current to prev
        // storing in head will be useful for the last call
        head = reverseList(curr.next , curr, head);
        //fix the curr.next to point to prev to reverse it
        curr.next = prev;
        return head;


    }




    public static void main(String[] args) {
        int[] arr={1,2,3,4,5}         ;
        Node head = makelist(arr);
         Node ref = head;
        //printAllNodes(reverseList(head, null, head));
        System.out.println();
        printAllNodes(reverseList(ref));

    }


}
