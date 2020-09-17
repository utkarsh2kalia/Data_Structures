package Arrays;
import java.util.*;
public class RainWaterTrapping {
    public static int rainwater(int heights[]){
        if(heights.length<=1)
            return 0;

        int left = 0, right = heights.length-1, water = 0;

        int maxLeft = heights[left];
        int maxRight = heights[right];

        while(left < right){

            if(heights[left] <= heights[right]){
                left++;
                maxLeft = Math.max(heights[left], maxLeft);
                water+= maxLeft - heights[left];
            }

            else{
                right--;
                maxRight = Math.max(heights[right] , maxRight);
                water+= maxRight - heights[right];
            }

        }
        return water;
    }
    public static void main(String[] args)
    {
        int[] heights = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };

        System.out.print("Maximum amount of water that can be trapped is " +
                rainwater(heights));
    }
}
