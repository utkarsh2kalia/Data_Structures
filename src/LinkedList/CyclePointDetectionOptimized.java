package LinkedList;
// if slow travels a+b, fast travels 2a+2b, which is the point where it meets slow
//A+B+N = 2A+2B   where N is some distance travelled in loop
//N=A+B

import static LinkedList.LinkedList.makelist;

public class CyclePointDetectionOptimized {
// function to detect point of cycle
  public static Node detectcyclepointoptimized(Node head){
      Node fast = head, slow = head;

      while(fast != null && fast.next != null ){
          slow = slow.next;
          fast = fast.next.next;
          if(fast == slow){
              Node slow2 = head;
              while(slow != slow2){
                  slow = slow.next;
                  slow2 = slow2.next;
              }
              return slow2;
          }
      }
      return null;
  }

    public static void main(String[] args) {
        int arr [] = {1,2,3,4,6,7};
        Node head = makelist(arr);
        head.next.next.next.next.next = head.next.next;
        System.out.println(detectcyclepointoptimized(head).data);
    }
}
