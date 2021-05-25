package StacksAndQueues;

import java.util.Stack;
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
//Example 2:
//
//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
//Example 3:
//
//Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//Output: 22
//Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
public class ReversePolishString {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token: tokens ){

            if(!"+-/*".contains(token)){
                stack.push(Integer.parseInt(token));
                continue;
            }

            int num2 = stack.pop();
            int num1 = stack.pop();

            int res = 0;

            switch(token){
                case "+": res = num1 + num2;
                    break;
                case "-": res = num1 - num2;
                    break;
                case "*": res = num1 * num2;
                    break;
                case "/": res = num1 / num2;
                    break;

            }
            stack.push(res);

        }
        return stack.pop();
    }

}
