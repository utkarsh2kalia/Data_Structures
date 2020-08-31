package LinkedList;

import java.util.Scanner;
//import LinkedList.LinkedList;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of linked list:");
        int n = sc.nextInt();
//        System.out.println("Enter the value of k");
//        int k = sc.nextInt();

        Node head = new Node(sc.nextInt());
        Node ref = head;
        while(--n!=0) {
            head.next = new Node(sc.nextInt());
            head = head.next;
        }
        //head = reverseList(ref, null, ref);
//        printAllNodes(reverseKnodes(head, k));
        printAllNodes(reverseKnodes(ref,3));
    }
}
