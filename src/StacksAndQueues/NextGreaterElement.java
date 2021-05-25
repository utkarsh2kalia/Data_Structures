package StacksAndQueues;

import java.util.Stack;

public class NextGreaterElement {
//    Given a circular array (the next element of the last element is the first element of the array),
//    print the Next Greater Number for every element.
//    The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
//    which means you could search circularly to find its next greater number.
//    If it doesn't exist, output -1 for this number.
//
//    Example 1:
//    Input: [1,2,1]
//    Output: [2,-1,2]


    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<Integer>();
        int length = nums.length;
        int ans[] = new int[length];
        for(int i = 2*length; i>=0; i--){

            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i%length]){

                stack.pop();

            }

            ans[i%length] = stack.isEmpty()?-1:nums[stack.peek()];

            stack.push(i % length);

        }

        return ans;

    }





}
