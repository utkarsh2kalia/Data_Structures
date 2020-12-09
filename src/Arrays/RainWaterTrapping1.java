package Arrays;

public class RainWaterTrapping1 {

    public static int trappingrainwater(int heights[]){
        if(heights.length==0) return 0;
        int left_max[] = new int[heights.length];
        int right_max[] = new int[heights.length];
        int water = 0;
        left_max[0] = heights[0];
        right_max[heights.length-1] = heights[heights.length-1];
        for(int i = 1; i<heights.length; i++){
            left_max[i] = Math.max(heights[i], left_max[i-1]);
        }
        for(int i = heights.length-2; i>=0; i--){
            right_max[i] = Math.max(heights[i], right_max[i+1]);
        }
        for(int i = 0; i<heights.length; i++){
            water+= Math.min(left_max[i], right_max[i]) - heights[i];
        }
        return water;
    }
    public static int trappingrainwateroptimized(int heights[]){
       int left = 0, right = heights.length-1;
       int water = 0, maxLeft = heights[0], maxRight = heights[heights.length-1];
       while(left < right)
       {
           if (heights[left] <= heights[right])
           {
               left++;
               maxLeft = Integer.max(maxLeft, heights[left]);
               water += (maxLeft - heights[left]);
           }
           else
           {
               right--;
               maxRight = Integer.max(maxRight, heights[right]);
               water += (maxRight - heights[right]);
           }


       }
        return water;
    }

    public static void main(String[] args) {
        int arr[]= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingrainwater(arr));
        System.out.println(trappingrainwateroptimized(arr));
    }


}
