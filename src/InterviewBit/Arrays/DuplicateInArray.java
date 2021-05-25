package InterviewBit.Arrays;

import java.util.List;

//Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
public class DuplicateInArray {

    public int repeatedNumber(final List<Integer> nums) {
        int tortoise = nums.get(0);
        int hare = nums.get(0);
        do {
            tortoise = nums.get(tortoise);
            hare = nums.get(nums.get(hare));
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums.get(0);
        while (tortoise != hare) {
            tortoise = nums.get(tortoise);
            hare = nums.get(hare);
        }

        return hare;


    }
}