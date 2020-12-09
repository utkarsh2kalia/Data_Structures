package Arrays;
//
//Given a sorted array nums,
// remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
//
//        Do not allocate extra space for another array,
//        you must do this by modifying the input array in-place with O(1) extra memory.
//
//        Example 1:
//
//        Given nums = [1,1,1,2,2,3],
//
//        Your function should return length = 5,
//        with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveduplicatesFromSortedArray2 {
    public static int removeduplicates1(int nums[]){
        int i = 0;
    for(int n: nums){
        // only move i if the elements
        if(i<2 || n > nums[i-2])
            nums[i++] = n;

    }
    return i;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        int i = removeduplicates1(nums);
        IntStream.range(0,i).forEach(index -> System.out.print(nums[index]+" "));
    }

}
