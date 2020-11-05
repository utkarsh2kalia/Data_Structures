package Priorityqueue;

import javax.lang.model.util.Elements;
import java.util.PriorityQueue;

public class KthSmallestElementFromArrayOfIntervals {

//    Given an array of intervals arr[] of size N, the task is to find the
//    Kth smallest element among all the elements within the intervals of the given array.
//
//    Examples:
//
//    Input : arr[] = {{5, 11}, {10, 15}, {12, 20}}, K =12
//    Output: 13
//    Explanation: Elements in the given array of intervals are:
//    {5, 6, 7, 8, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 17, 18, 19, 20}.
//    Therefore, the Kth(=12th) smallest element is 13.
//
//    Input: arr[] = {{5, 11}, {10, 15}, {12, 20}}, K = 7
//    Output:10

public static int KthSmallest(int arr[][], int k)
{
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
    for(int i = 0; i<arr.length; i++)
    {
        pq.offer(new int[]{
                arr[i][0], arr[i][1]
        });
    }
    int count = 1;// store the number of elements
    // count is nitialized to 1 bcoz, in case of 2,3
    while(count<k)
    {
        int interval[]  = pq.poll();
        if(interval[0] < interval[1])
        {
            // add to queue only if the minimum interval is less than the maximum interval
            // eg in case of (3,3), we will only increase the count and not push it back to queue
            // the priority queue will always have the lowest start interval first
            pq.offer(new int[]{
                    interval[0]+1,interval[1]
            });
        }
        count++;
    }


    // return the kth element

    return pq.peek()[0];
}

    public static void main(String[] args) {
        int arr[][] = {{5, 11}, {10, 15}, {12, 20}};
        System.out.println(KthSmallest(arr, 13));
    }

}
