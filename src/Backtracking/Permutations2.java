package Backtracking;

import java.util.*;

//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [1,1,2]
//        Output:
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
public class Permutations2 {


    public List<List<Integer>> permute2(int nums[])
    {
        List<List<Integer>> list = new LinkedList<>();
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> templist, int nums[], boolean used[])
    {
        if(templist.size() == nums.length)
            list.add(new ArrayList<>(templist));
        else
        {
            for(int i =0; i<nums.length; i++)
            {
                if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1])
                    continue;
                used[i] = true;
                templist.add(nums[i]);
                backtrack(list, templist, nums, used);
                used[i] = false;
                templist.remove(templist.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations2 obj = new Permutations2();
        int nums[] = {1,1,2};
        System.out.println(obj.permute2(nums));

    }

}
