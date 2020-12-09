package Arrays;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int max_kadane = kadane(A);
        int max_wrap = 0;
        for (int i = 0; i < A.length; i++) {
            max_wrap += A[i]; // Calculate array-sum
            A[i] = -A[i]; // invert the array (change sign)
        }
        max_wrap += kadane(A);// sum of Array elements and negated kadane
        if(max_wrap == 0)
            return max_kadane;
        return Math.max(max_kadane, max_wrap);
    }

    int kadane(int[] nums) {
        int max_ending_here = nums[0];
        int max_so_far = nums[0];
        for(int i=1; i<nums.length; i++) {
            max_ending_here = Math.max(max_ending_here + nums[i], nums[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }
}
