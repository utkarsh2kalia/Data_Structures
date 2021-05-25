package Arrays;

import java.util.TreeSet;

//https://www.interviewbit.com/problems/maximum-sum-triplet/
//Given an array A containing N integers.
//
//You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.
//
//If no such triplet exist return 0.
public class MaximumSumTriplet {

    public static int solve(int[] arr) {

        int n = arr.length;
        int rightMax[] = new int[n];
        rightMax[n-1] = arr[n-1];
        // first we need to store the maximum sum from right
        for(int i =n-2; i>=0; i--)
        {
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }
        // TreeSet to get the element smaller than current element using lower
        TreeSet<Integer> set = new TreeSet<>();
        set.add(arr[0]);
        int res = Integer.MIN_VALUE;
        for(int i = 1; i<n-1; i++)
        {
            // get maximum on left of current element
            Integer lmax = set.lower(arr[i]);
            int rmax = rightMax[i+1];
            if(lmax!=null && rmax>arr[i]){
                res = Math.max(res, lmax+rmax+arr[i]);
            }
        }
        return (res == Integer.MIN_VALUE)?-1:res;


    }

    public static void main(String[] args) {
        int []arr = {2, 5, 3, 1, 4, 9};//16
        System.out.println(solve(arr));
    }



}
