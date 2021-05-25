package Arrays;

import java.util.HashMap;
import java.util.Map;

// Also print all subarrays with the given sum
public class MaximumLengthSubarrayWithGivenSum {

    public static int subarraylength(int arr[], int k)


    {

        // we will be storing the ending index of each sum
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int endingIndex = -1;// to mark the end of the subarray of given length
        for(int i =0; i<arr.length; i++)
        {
            sum+=arr[i];

            if(map.containsKey(sum - k) && maxLen< i - map.get(sum-k))
            {
                // means a subarray with given sum exists
                maxLen = i - map.get(sum-k) ;
                endingIndex = i;

            }
            map.put(sum, map.getOrDefault(sum,i)); // put either the previous value or teh new value


        }
        System.out.println("["+(endingIndex-maxLen+1)+","+endingIndex+"]");


        return 0;


    }


    public static void main(String[] args) {

        int arr[] = {  5, 6, -5, 5, 3, 5, 3, -2, 0 };
        subarraylength(arr,8 );
    }


}
