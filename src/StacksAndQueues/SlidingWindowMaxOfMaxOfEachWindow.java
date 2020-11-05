package StacksAndQueues;

//Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
//        Examples :
//
//        Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
//        Output: 3 3 4 5 5 5 6
//        Explanation:
//        Maximum of 1, 2, 3 is 3
//        Maximum of 2, 3, 1 is 3
//        Maximum of 3, 1, 4 is 4
//        Maximum of 1, 4, 5 is 5
//        Maximum of 4, 5, 2 is 5
//        Maximum of 5, 2, 3 is 5
//        Maximum of 2, 3, 6 is 6

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SlidingWindowMaxOfMaxOfEachWindow {
    // create a queue with the index of  max element at the top
    public static void maxwindow(int arr[], int k)
    {
        List<Integer> list = new LinkedList<>();
        if(arr.length<k)
            return;
        Deque<Integer> qu = new LinkedList<>();
        // process the first k elements
        int i;
        for(i = 0; i<k; i++)
        {
            // keep removing elements from last until the elements are smaller than current element
            while(!qu.isEmpty() && arr[i] >= arr[qu.peekLast()])
                qu.removeLast();

            qu.addLast(i);
        }
        // now the queue has the maximum element of the first window
        for(; i<arr.length; i++)
        {
            // print the max element of previous window
            System.out.print(arr[qu.peekFirst()]+" ");
            // remove the element out of window
            while(!qu.isEmpty() && qu.peekFirst() <= i-k)
                qu.removeFirst();
            // remove elements smaller than the current element
            while (!qu.isEmpty() && arr[i] >= arr[qu.peekLast()])
                qu.removeLast();

            // add the current element
            qu.addLast(i);
        }
        System.out.print(arr[qu.peek()]);



    }


        public static void main(String[] args)
        {
            int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
            int k = 3;
            maxwindow(arr, k);
        }




}
















