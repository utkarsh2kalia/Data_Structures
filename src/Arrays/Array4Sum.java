package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Notice that the solution set must not contain duplicate quadruplets.
//
//
//
//Example 1:
//
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

public class Array4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i  =0; i<nums.length; i++){

            for(int j = i+1; j<nums.length; j++)
            {
                if(i>0 && nums[i] == nums[i-1] || j>i+1 && nums[j] == nums[j-1] ){
                    continue;
                }
                sum3(i, j, nums, target, list);
            }


        }
        return list;



    }


    public void sum3(int i, int j, int nums[], int target, List<List<Integer>> list ){

        int low = j+1, hi = nums.length-1;

        while(low<hi){

            int sum = nums[i] + nums[j] + nums[low] + nums[hi];

            if(sum == target)
            {
                list.add(Arrays.asList(nums[i], nums[j], nums[low++], nums[hi--]));
                // System.out.println(list+" "+i+j);
                while(low < hi && nums[low] == nums[low - 1])
                    low++;
            }
            else if(sum<target)
                low++;
            else
                hi--;
        }
    }

    public static void main(String[] args) {
        int array[] = {1,0,-1,0,-2,2};
        Array4Sum array4Sum = new Array4Sum();
        System.out.println(array4Sum.fourSum(array, 0));

    }
}
