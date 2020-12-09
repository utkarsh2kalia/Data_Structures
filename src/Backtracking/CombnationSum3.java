package Backtracking;

import java.util.ArrayList;
import java.util.List;
//Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//        Only numbers 1 through 9 are used.
//        Each number is used at most once.
//        Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
//
//
//
//        Example 1:
//
//        Input: k = 3, n = 7
//        Output: [[1,2,4]]
//        Explanation:
//        1 + 2 + 4 = 7
//        There are no other valid combinations.
public class CombnationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), k, n, 1);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start) {
        if(tempList.size() > k) return; /** no solution */
        else if(tempList.size() == k && remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                backtrack(list, tempList, k, remain-i, i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
