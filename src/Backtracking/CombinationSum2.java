package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;


//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//        Each number in candidates may only be used once in the combination.
//
//        Note: The solution set must not contain duplicate combinations.
//
//
//
//        Example 1:
//
//        Input: candidates = [10,1,2,7,6,1,5], target = 8
//        Output:
//        [
//        [1,1,6],
//        [1,2,5],
//        [1,7],
//        [2,6]
//        ]
// each candidate cn only be used once
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int candidates[],int target)
    {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0 );
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> templist, int nums[], int remain, int start )
    {
        if(remain<0)
            return;
        else if(remain == 0)
            list.add(new ArrayList<>(templist));
        else
        {
            for(int i = start; i<nums.length; i++)
            {
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                templist.add(nums[i]);
                backtrack(list, templist, nums, remain-nums[i], i+1);// no reuse
                templist.remove(templist.size() - 1);

            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();
        int nums[] = {10,1,2,7,6,1,5};

        System.out.println(obj.combinationSum2(nums,8));
    }
}
