package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubarrayWithEqual1sAnd2s {

    public static int maxLengthSubarray(int arr[]){

        Map<Integer, Integer> map =new HashMap<>();
        map.put(0,-1); // for condition when subarray with 0 sum starts at 0 index

        int sum =0;
        int maxLen = 0;
        int endIndex = -1;

        for(int i =0; i<arr.length; i++)
        {
            // -1 in case of 0
            sum+=(arr[i] == 0)?-1:1;
            System.out.println(sum);

            // means the subarray between them has a 0 sum
            if(map.containsKey(sum))
            {
                if(maxLen< i-map.get(sum))
                {
                    maxLen = i - map.get(sum);
                    endIndex = i;

                }
            }
            map.put(sum, map.getOrDefault(sum,i));

        }
        if(endIndex!=1){
            System.out.println("Subarray:["+(endIndex-maxLen+1)+","+(endIndex)+"]");
        }
        return maxLen;

    }
    public static void main(String[] args) {

        int[] A = { 0, 0, 1, 0, 1, 0, 0 };

        System.out.println( maxLengthSubarray(A));
    }



}
