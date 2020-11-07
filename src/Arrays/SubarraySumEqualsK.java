package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
//
//
//
//        Example 1:
//
//        Input: nums = [1,1,1], k = 2
//        Output: 2
//        Example 2:
//
//        Input: nums = [1,2,3], k = 3
//        Output: 2
public class SubarraySumEqualsK {
    public int subarraySum(int nums[], int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += nums[i];
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum,0)+1);

        }
        return count;


    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        System.out.println(obj.subarraySum(arr, 3));
    }

}
