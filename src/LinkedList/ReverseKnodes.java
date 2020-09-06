package LinkedList;

import java.util.Scanner;
//import LinkedList.LinkedList;

import static LinkedList.LinkedList.createList;
import static LinkedList.LinkedList.printAllNodes;
//import static LinkedList.ReverseLinkedList.reverseList;


public class ReverseKnodes {
    public static Node reverseKnodes(Node head, int k)
    {
        if(head == null)
            return null;
        int count = 0;
        Node curr = head;
        Node prev = null;

        while (curr != null && count++ < k){
            // store the current next in next
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // join the links
        head.next = reverseKnodes(curr, k);

        return prev;


    }
    public static void main(String[] args) {

        Node head = createList();
        printAllNodes(reverseKnodes(head,3));
    }
}
