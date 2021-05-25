package InterviewBit.Arrays;

public class MaxSumContiguousSubarray {


//    Find the contiguous subarray within an array, A of length N which has the largest sum.
//    Input 1:
//    A = [1, 2, 3, 4, -10]
//
//    Output 1:
//            10
//
//    Explanation 1:
//    The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
//
//    Input 2:
//    A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
//
//    Output 2:
//            6
//
//    Explanation 2:
//    The subarray [4,-1,2,1] has the maximum possible sum of 6.

    public int maxSubArray(final int[] A) {

        int maxSoFar = Integer.MIN_VALUE;

        int maxEndingHere  = 0;

        for(int i:A){


            maxEndingHere = Math.max(maxEndingHere + i, i);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;




    }



}
