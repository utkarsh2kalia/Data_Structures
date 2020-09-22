package StacksAndQueues;

import java.util.Stack;

public class BalancingBrackets {
    public static boolean isValid(String exp) {

        if(exp.length()%2!=0)
            return false;

        Stack<Character> stack = new Stack<>();

        for(var ch: exp.toCharArray()){
            if(ch=='(')
                stack.push(')');
            else if(ch=='{')
                stack.push('}');
            else if(ch=='[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop()!=ch)
                return false;
        }
        return stack.empty();

    }

    public static void main(String[] args) {
        String exp = "((({}[])))";
        System.out.println(isValid(exp));
    }
}
