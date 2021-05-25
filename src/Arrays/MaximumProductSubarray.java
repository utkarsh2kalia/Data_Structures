package Arrays;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int minEnding = 0, maxEnding = 0, maxSoFar=0;
        if(nums.length ==1)
            return nums[0];

        for(int i: nums)
        {
            // store the previous ending
            int temp = maxEnding;

            maxEnding = Math.max(i, Math.max(i*maxEnding, i*minEnding));

            minEnding = Math.min(i, Math.min(i*temp, i*minEnding));

            maxSoFar = Math.max(maxEnding, maxSoFar);


        }
        return maxSoFar;

    }

    public static void main(String[] args) {
        int arr[] = { -6, 4, -5, 8, -10, 0, 8 };
        System.out.println(new MaximumProductSubarray().maxProduct(arr));
    }
}
