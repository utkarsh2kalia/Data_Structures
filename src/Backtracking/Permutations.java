package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given a collection of distinct integers, return all possible permutations.
//
//        Example:
//
//        Input: [1,2,3]
//        Output:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
public class Permutations {
    public List<List<Integer>> permute(int nums[])
    {
        List<List<Integer>> list = new LinkedList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> templist, int nums[]){
        if(templist.size() == nums.length)
            list.add(new ArrayList<>(templist));
        for(int i = 0; i<nums.length; i++)
        {
            if(templist.contains(nums[i]))// element already exists, skip
                continue;
            templist.add(nums[i]);
            backtrack(list, templist, nums);
            templist.remove(templist.size()-1);
        }
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int nums[] ={1,2,3};
        System.out.println(obj.permute(nums));
    }
}
