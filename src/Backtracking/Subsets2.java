package Backtracking;

import javax.imageio.stream.ImageInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
//        Note: The solution set must not contain duplicate subsets.
//
//        Example:
//
//        Input: [1,2,2]
//        Output:
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]

public class Subsets2 {
    public List<List<Integer>> subset2(int nums[])
    {
        List<List<Integer>> list = new LinkedList<>();
        backtrack(new ArrayList<>(), list, nums, 0);
        return list;
    }
    public void backtrack(List<Integer> templist, List<List<Integer>> list, int nums[], int start){
        list.add(new ArrayList<>(templist));
        for(int i = start; i<nums.length; i++)
        {


            // for duplicates
            if(i> start && nums[i] == nums[i-1])// for duplicates, eg when 122, middle 2 is removed,i = 1, then start = 1, but after removi ng i=2 so greater tha
                continue;
            templist.add(nums[i]);
            backtrack(templist, list, nums, i+1);
            templist.remove(templist.size()-1);
        }

    }

    public static void main(String[] args) {
        Subsets2 obj = new Subsets2();
        int nums[] ={1,2,2};
        System.out.println(obj.subset2(nums));
    }
}
