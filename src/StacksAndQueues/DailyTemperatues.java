package StacksAndQueues;

import java.util.Stack;

public class DailyTemperatues {
    public int[] dailyTemperatures(int[] temperatures) {

        int length = temperatures.length;
        Stack<Integer> stack = new Stack<Integer>();
        int ans[] = new int[length];
        for(int i = length-1; i>=0; i-- )
        {

            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
            { stack.pop();
            }

            ans[i] = stack.isEmpty()?0:stack.peek() - i;

            stack.push(i);


        }
        return ans;


    }
}
