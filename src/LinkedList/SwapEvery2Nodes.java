package LinkedList;

class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val = val;
        next = null;
    }
    public static ListNode makeList(int arr[])
    {
        ListNode ref = new ListNode(0);
        ListNode head = ref;
        for(int num: arr){
            ref.next = new ListNode(num);
            ref = ref.next;
        }
        return head.next;

    }
    public static void printAllNodes(ListNode head)
    {
        while(head !=null)
        {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.print("null");
    }
}

public class SwapEvery2Nodes {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        //ListNode p = swapPai
        ListNode prev = null;
        ListNode curr = head;
        int count = 0;
        while(count++!=2 && curr!=null)
        {
            // save the next
            ListNode next = curr.next;
            //point next of curr to back
            curr.next = prev;

            prev = curr;
            curr = next;

        }
//        System.out.println(head.val);
        head.next = swapPairs(curr);
        return prev;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        ListNode.printAllNodes(swapPairs( ListNode.makeList(arr)));

    }
}
