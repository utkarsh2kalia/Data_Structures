package Arrays;

public class KadaneAlgorithmMaximumSubarraySum {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_end_here = 0;
        int max = 0;
        for(int i = 0; i<nums.length; i++)
        {
            max_end_here = max_end_here+nums[i];
            // eg max_endng may be -2, i = 5; so max ending here = max(-2,5) = 5
            max_end_here = Integer.max(max_end_here, nums[i] );


            max_so_far = Integer.max(max_end_here, max_so_far);


        }

        return max_so_far;
    }
}
