package Arrays;

import java.util.Deque;
import java.util.LinkedList;

//Algorithm :
//        Create a deque to store k elements.
//        Run a loop and insert first k elements in the deque. While inserting the element if the element at the back of the queue is smaller than the current element remove all those elements and then insert the element.
//        Now, run a loop from k to end of the array.
//        Print the front element of the array
//        Remove the element from the front of the queue if they are out of the current window.
//        Insert the next element in the deque. While inserting the element if the element at the back of the queue is smaller than the current element remove all those elements and then insert the element.
//        Print the maximum element of the last window.
public class MaximumValuesInAllSubarraysOfKsize {

    // using dequeue
    // the queue will always contain the maximum element at the start

    public static void maxValue(int arr[], int k){
        Deque<Integer> qi = new LinkedList<>();
        int i, n = arr.length;
        // check for the first k characters in the array
        for(i = 0; i<k; i++)
        {   // we are storing the index and not the number in the deque
            // if the current number is greater than the top if queue, remove all
            while(!qi.isEmpty() && arr[i]>=arr[qi.peekLast()])
            {
                qi.removeLast();
            }
            // now add the current to the queue
            qi.addLast(i);
        }

        // now process the rest of the numbers
        for(; i<n; i++){
            // print the top element which is the largest in previous subarray
            System.out.println(arr[qi.peek ()]+" ");

            // remove the elements that are out of teh window
            while ((!qi.isEmpty()) && qi.peek() <= i - k)
                qi.removeFirst();

            while(!qi.isEmpty() && arr[i]>=arr[qi.peekLast()])
            {
                qi.removeLast();
            }
            qi.addLast(i);

        }
        // max of last subarray
        System.out.print(arr[qi.peek()]);

    }

    public static void main(String[] args) {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        maxValue(arr,k);

    }


}
