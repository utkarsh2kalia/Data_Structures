package LinkedList;

import javax.imageio.stream.ImageInputStream;

import static LinkedList.LinkedList.makelist;
import static LinkedList.LinkedList.printAllNodes;

public class RemoveDuplicatesFromList2 {
    public static Node removeduplicatesfromlist2(Node head) {
        if (head == null)
            return head;
            // create a dummy node
            Node dummy = new Node(0);

            dummy.next = head;
            Node prev = dummy; // prev points to dummy
            Node curr = head;

            while (curr != null) {

                // keep moving until the next of current and prev are equal
                while (curr.next != null && prev.next.data == curr.next.data) {
                    curr = curr.next;
                }

                // if next of curr is not duplicate
                if (prev.next == curr)
                    prev = prev.next;
                else
                    // in case of duplicates
                    prev.next = curr.next;
                // move curr to next

                curr = curr.next;

            }
//            head = dummy.next;

            return dummy.next;
        }

    Node removeDuplicates(Node head)
    {
        // Your code here
        Node curr = head, prev = head;
        while(curr!=null)
        {
            if(prev.data != curr.data)

            {
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,3,5,5,6,7};

        printAllNodes(removeduplicatesfromlist2(makelist(arr)));
    }
    }
