package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<List<Integer>> permuteAgain(int nums[]){

        // a list for storing the output
        List<List<Integer>> out = new ArrayList<>();
        // list for storing the numbers
        List<Integer> num = new ArrayList<Integer>();
        for(int val: nums){
            num.add(val);
        }
        int n = nums.length;

        backtrackAgain(n, num, out, 0);

        return out;

    }

    public void backtrackAgain(int n, List<Integer> num, List<List<Integer>> out, int first){


        if(first == n) {
            out.add(new ArrayList(num));
            return;
        }

        for(int i = first; i<n; i++){

            Collections.swap(num, i, first);
            backtrackAgain(n, num, out, first+1);
            Collections.swap(num, i, first);

        }


    }


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
        System.out.println(obj.permuteAgain(nums));
    }
}
