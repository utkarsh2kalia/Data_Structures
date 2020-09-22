package StacksAndQueues;

import java.util.Stack;

//Input: s = "3[a]2[bc]"
//        Output: "aaabcbc"
//        Example 2:
//
//        Input: s = "3[a2[c]]"
//        Output: "accaccacc"
public class DecodeString {

    public static String decode_string(String s){
        // create 2 stacks to store the integer and other values
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            // if the current character is a digit, get the number from it and store in countstack
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            // if the character is an opening brace, push it in the
            else if (s.charAt(idx) == '[') {
                // add the result to stack
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                // pop out the character from stack
                StringBuilder temp = new StringBuilder (resStack.pop());
                //pop out the repeat times
                int repeatTimes = countStack.pop();
                // add the string to temp the count times
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                // store temp in string
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;

            }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decode_string(s));
    }
}
