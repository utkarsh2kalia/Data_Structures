package InterviewBit.Arrays;

import java.util.ArrayList;

public class LeadersInAnArray {

//    Given an integer array A containing N distinct integers, you have to find all the leaders in the array A.
//
//An element is leader if it is strictly greater than all the elements to its right side.q

//    A = [16, 17, 4, 3, 5, 2]
//     Element 17 is strictly greater than all the elements on the right side to it.
// Element 2 is strictly greater than all the elements on the right side to it.
// Element 5 is strictly greater than all the elements on the right side to it.
// So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.

    public int[] solve(int[] arr) {
        int n = arr.length;
        int max = arr[n-1];

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[n-1]);
        for(int i = n-2;i>=0;i--)
        {
            if(arr[i]>max)
            {
                list.add(arr[i]);
                max = arr[i];
            }
        }

        int brr[] = new int[list.size()];
        n = list.size();
        for(int i =0; i<brr.length; i++)
            brr[i] = list.get(i);
        return brr;

    }
}
