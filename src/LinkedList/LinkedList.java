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
    // function to create a list
    public static Node createList(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of linked list:");
        int n = sc.nextInt();

        Node head = new Node(sc.nextInt());
        Node ref = head;
        while(--n!=0) {
            head.next = new Node(sc.nextInt());
            head = head.next;
        }
        return ref;

    }
    public static Node makelist(int arr[])
    {
        Node ref = new Node(0);
        Node head = ref;
        for(int num: arr){
            ref.next = new Node(num);
            ref = ref.next;
        }
        return head.next;

    }
    public static void main(String[] args) {
        Node head = createList();

        printAllNodes(head);

    }
}
