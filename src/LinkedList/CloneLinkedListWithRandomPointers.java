package LinkedList;

import java.util.HashMap;
class Node2{
    Node2 random;
    int val ;
    Node2 next;
    public Node2(int val, Node2 next, Node2 random) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}
//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//        Return a deep copy of the list.
//
//        The Linked List is represented in the input/output as a list of n nodes.
//        Each node is represented as a pair of [val, random_index] where:
//
//        val: an integer representing Node.val
//        random_index: the index of the node (range from 0 to n-1) where
//        random pointer points to, or null if it does not point to any node.
public class CloneLinkedListWithRandomPointers {
    HashMap<Node2, Node2> visitedHash = new HashMap<Node2, Node2>();

    public Node2 copyRandomList(Node2 head) {

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the cloned version of
        // it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        // Create a new node with the value same as old node. (i.e. copy the node)
        Node2 node = new Node2(head.val , null, null);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}
