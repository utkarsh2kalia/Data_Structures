package Arrays;
//Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

//Example 1:

//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0, length = Integer.MAX_VALUE, left=0;

        for(int i = 0; i<nums.length; i++)
        {
            // add the number to the sum
            sum+=nums[i];

            while(sum>=target){

                length = Math.min(length, i +1 - left);
                sum -= nums[left++];

            }
        }
        return (length!=Integer.MAX_VALUE)?length:0;

    }


}
