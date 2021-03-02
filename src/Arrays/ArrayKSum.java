package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayKSum {

    public List<List<Integer>> kSum(int nums[], int target, int start, int k){

        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || start == nums.length || target < nums[start]*k || target > nums[nums.length - 1] * k){
            return res;
        }
        if(k == 2)
            return twoSum(nums, target, start);

        for( int i = start; i< nums.length; i++){
            if(i == start || nums[i] != nums[i-1]){
                for(var set: kSum(nums, target - nums[i], i+1, k-1)){
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size()-1).addAll(set);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int nums[], int target, int start){
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length-1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }

    public static void main(String[] args) {

        ArrayKSum arrayKSum = new ArrayKSum();
        int[] nums = {-2,-1,-1,1,1,2,2};


        Arrays.sort(nums);
        System.out.println(arrayKSum.kSum(nums, 0, 0,4));





    }



}
