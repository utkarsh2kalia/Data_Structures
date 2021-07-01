package DynamicProgramming;
//Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: The repeated subarray with maximum length is [3,2,1].
//Example 2:
//
//Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//Output: 5
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {

        int dp[][] = new int[nums1.length+ 1][nums2.length+1];
        int ans = 0;
        for(int i = nums1.length - 1; i>=0; i--)
        {
            for(int j = nums2.length - 1; j>=0; j--){

                if(nums1[i] == nums2[j])
                {
                    dp[i][j] = dp[i+1][j+1] +1;

                    ans = (ans<dp[i][j])?dp[i][j]:ans;
                }


            }
        }


        return ans;

    }

}
