package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListIterative {
    public Node2 copyRandomList(Node2 head) {

        if(head == null)
            return null;

        Map<Node2, Node2> visited = new HashMap<>();
        Node2 newHead = new Node2(head.val);
        visited.put(head, newHead);
        Node2 cur = head;



        while(cur!=null){

            if(cur.next!=null)
            {
                // if the current Node2 is not seen before
                if(!visited.containsKey(cur.next))
                {
                    Node2 newNext = new Node2(cur.next.val );
                    visited.put(cur.next, newNext);
                }

                // now put this Node2 in the next of the current
                visited.get(cur).next = visited.get(cur.next);
            }
            if(cur.random!=null)
            {
                // if the random Node2 is not already present
                if(!visited.containsKey(cur.random)){

                    Node2 newRandom = new Node2(cur.random.val);
                    visited.put(cur.random, newRandom);
                }
                // now put the value into the next Node2
                visited.get(cur).random = visited.get(cur.random);
            }

            cur = cur.next;


        }
        return newHead;



    }
}
