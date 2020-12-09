package LinkedList;

public class SortABinaryLinkedList {
    public ListNode solve(ListNode A) {
        int []count = new int[2];
        count[0] = 0; count[1] = 0;
        ListNode ptr = A;
        while(ptr!=null)
        {
            count[ptr.val]++;
            ptr = ptr.next;
        }

        ptr = A;int i =0;
        while(ptr!=null)
        {
            if(count[i]==0)
                i++;
            else
            {ptr.val = i;
                count[i]--;

                ptr = ptr.next;
            }
        }
        return A;
    }
}
