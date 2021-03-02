package Arrays;


import java.util.HashSet;
import java.util.Set;
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//
//
//        Example 1:
//
//        Input: nums = [100,4,200,1,3,2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//        Example 2:
//
//        Input: nums = [0,3,7,2,5,8,4,6,0,1]
//        Output: 9
public class LongestConsecutiveSequence {


    public int longestConsecutive(int[] nums) {
        HashSet<Integer> num_set = new HashSet<Integer>();
        for(int num: nums){
            num_set.add(num);
        }

        int longestStreak = 0;


        for(int num: num_set){

            // start a new streak if the number is not present
            // eg start with 0, 0-1=-1 is not present, so it will find all the consec numbers starting with 1, for 1, 0 is already present, so no need to search
            // basically we are  trying to find the starting point of a consecutive series
            if(!num_set.contains(num-1))
            {
                int currentNum = num;
                int currentStreak = 1;
                // till the time the next number is found keep increasing the streak
                while(num_set.contains(currentNum+1)){

                    currentNum+=1;
                    currentStreak+=1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }


        }
        return longestStreak;

    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int []nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums
        ));
    }
}
