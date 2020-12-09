package DynamicProgramming;

import java.util.Arrays;
//Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Your goal is to reach the last index in the minimum number of jumps.
//
//        You can assume that you can always reach the last index.
//
//
//
//        Example 1:
//
//        Input: nums = [2,3,1,1,4]
//        Output: 2
public class MinimumJumpsToReachDest {
    public static  int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            // curFarthest stores the farthest we can go for the current element
            curFarthest = Math.max(curFarthest, i + A[i]);
            // current end stores the length we have to go for the current chosen element
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int arr[] = {4,2,0,3,2,0,1,8};
        System.out.println(jump(arr));
    }
}
