package Arrays;
//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one duplicate number in nums, return this duplicate number.
//
//Follow-ups:
//
//How can we prove that at least one duplicate number must exist in nums?
//Can you solve the problem without modifying the array nums?
//Can you solve the problem using only constant, O(1) extra space?
//Can you solve the problem with runtime complexity less than O(n2)?
//
//
//Example 1:
//
//Input: nums = [1,3,4,2,2]
//Output: 2
// here the duplicate element can be present any number of times
public class DuplicateNumberUsingFloyd {

        public int findDuplicate(int[] nums) {
            // Find the intersection point of the two runners.
            int tortoise = nums[0];
            int hare = nums[0];
            do {
                tortoise = nums[tortoise];
                hare = nums[nums[hare]];
            } while (tortoise != hare);

            // Find the "entrance" to the cycle.
            tortoise = nums[0];
            while (tortoise != hare) {
                tortoise = nums[tortoise];
                hare = nums[hare];
            }

            return hare;
        }

}
