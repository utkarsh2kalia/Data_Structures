package StacksAndQueues;

import java.util.Arrays;

//You are given an array of integers nums, there is a sliding window of
//        size k which is moving from the very left of the array to the very right.
//        You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//        Return the max sliding window.
//        Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//        Output: [3,3,5,5,6,7]
//        Explanation:
//        Window position                Max
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
// O(n)
public class SlidingWindowMaximumMathod2 {

    public static int[] maximumineachwindow(int nums[], int k)
    {
        int n = nums.length;
        // means any of n or k is 0 we return empty array
        if(n * k ==0)
            return new int[0];
        if(k ==1) // window size is 1, then the number itself is maximum, so return it
            return nums;

        int [] left = new int[n];// will store maximum elements from left size in each window
        left[0] = nums[0];

        int[] right = new int[n];
        right[n-1] = nums[n-1];

        for(int i =1; i<n; i++){
            // for the starting of new window
            if(i%k == 0) left[i] = nums[i];
            else
                left[i] = Math.max(left[i-1], nums[i]);

            // right to left
            int j = n - i - 1; // start from the second last element
            if((j+1)%k == 0)// block end
                right[j] = nums[j];
            else
                right[j] = Math.max(right[j+1], nums[j]);
        }
        int[] output = new int[n - k + 1];
        for(int i = 0; i<n - k+1; i++)
            output[i] = Math.max(left[i+k-1], right[i]);
        return output;

    }

    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maximumineachwindow(arr, 3)));
    }

}
