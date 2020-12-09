package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
//You may return the combinations in any order.
//
//        The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
//        It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
//
//
//        Example 1:
//
//        Input: candidates = [2,3,6,7], target = 7
//        Output: [[2,2,3],[7]]
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int nums[] = {2,3,6,7};

        System.out.println(obj.combinationSum(nums,7));
    }
}
