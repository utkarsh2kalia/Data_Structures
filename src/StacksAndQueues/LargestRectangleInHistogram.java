package StacksAndQueues;


import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int heights[]){


        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;


        for(int i = 0; i<length; i++){
            // loop to pop until either the stack is empty or current height is less than the top
            while(stack.peek()!=-1 && heights[i]<=heights[stack.peek()]){

                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){

            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);

        }
        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
    }

}
