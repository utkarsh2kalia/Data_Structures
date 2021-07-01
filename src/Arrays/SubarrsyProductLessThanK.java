package Arrays;

public class SubarrsyProductLessThanK {

//    Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
//
//
//
//Example 1:
//
//Input: nums = [10,5,2,6], k = 100
//Output: 8
//Explanation: The 8 subarrays that have product less than 100 are:
//[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
//Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if(k<=1)
            return 0;
        int left = 0, ans = 0, prod = 1;


        for(int right = 0; right<nums.length; right++)
        {
            // multiply with the current number
            prod = prod * nums[right];

            // keep on moving left or shrinking the window till product is greater than k
            while(prod>=k)
            {
                prod /= nums[left++];
            }

            // increase the count of subarray
            ans+= right - left +1;
        }
        return ans;

    }
}
