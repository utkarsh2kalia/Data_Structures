package LinkedList;

import java.util.Scanner;

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
    public static Node reverseList(Node curr, Node prev, Node head)
    {
        if(curr == null){
            // fix the head pointer
            head = prev;
            return head;
        }
        // recur for next and send current to prev
        head = reverseList(curr.next , curr, head);
        //fix the curr.next to point to prev to reverse it
        curr.next = prev;
        return head;


    }
    public static void printAllNodes(Node head)
    {
        while(head !=null)
        {
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.print("null");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of linked list");
        int n = sc.nextInt();

        Node head = new Node(sc.nextInt());
        Node ref = head;
        while(--n!=0) {
            head.next = new Node(sc.nextInt());
            head = head.next;
        }
        head = reverseList(ref, null, ref);
        printAllNodes(head);

    }


}
