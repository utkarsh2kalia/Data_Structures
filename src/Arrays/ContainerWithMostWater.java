package Arrays;
//Input: height = [1,8,6,2,5,4,8,3,7]
//        Output: 49
//        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
//        In this case, the max area of water (blue section) the container can contain is 49.
public class ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int amaxx = Integer.MIN_VALUE;
            int left = 0, right = n-1;

            while(left<right)
            {
                amaxx = Math.max(amaxx, Math.min(height[left],height[right])*(right-left));
                if(height[left]<height[right])
                    left++;
                else
                    right--;
            }
            return amaxx;

        }
    }
}
