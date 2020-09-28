package Arrays;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class MaxArrayNotAdjacentSubsetSum {




        // Complete the maxSubsetSum function below.
        static int maxSubsetSum(int[] arr) {
            int sum[] = new int[arr.length];
            sum[0] = arr[0];
            sum[1] = arr[1];
            sum[2] = Math.max(arr[2]+sum[0],Math.max( arr[2], sum[0] ));
            int max = Integer.MIN_VALUE;
            for(int i = 3 ; i<arr.length; i++){
                sum[i] = Math.max(arr[i]+sum[i-3],Math.max(arr[i]+sum[i-2],Math.max( arr[i], sum[i-2])));
                if(max<sum[i])
                    max = sum[i];
            }
            return max;

        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {3, 5, -7, 8, 10};
        System.out.println(maxSubsetSum(arr));


//        Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.
//
//        For example, given an array{-2,1,3,-4,5}  we have the following possible subsets:
//
//        Subset      Sum
//[-2, 3, 5]   6
//                [-2, 3]      1
//                [-2, -4]    -6
//                [-2, 5]      3
//                [1, -4]     -3
//                [1, 5]       6
//                [3, 5]       8
//        Our maximum subset sum is .


    }
}
