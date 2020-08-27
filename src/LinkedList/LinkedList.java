package LinkedList;
import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;

    }

}

public class LinkedList {
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
        printAllNodes(ref);

    }
}
