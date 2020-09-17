package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static LinkedList.LinkedList.makelist;
import static LinkedList.LinkedList.printAllNodes;

public class SortLinkedList {
    public static Node listsort(Node head){
        Node curr = head;

        ArrayList<Node> list = new ArrayList<>();
        while(curr!=null){
            list.add(curr);
            curr = curr.next;
        }

        Collections.sort(list, new Comparator<Node>(){
            public int compare(Node a, Node b){
                return a.data - b.data;
            }
        });

        Node head1 = new Node(-1);
        Node current = head1;
        for(Node node: list){
            head1.next = node;
            head1 = head1.next;
        }
        head1.next = null;
        return current.next;

    }

    public static void main(String[] args) {
        int arr[] ={6,3,8,4,9};
        Node head = makelist(arr);
        printAllNodes(listsort(head));
    }
}
