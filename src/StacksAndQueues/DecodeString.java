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
        Stack<Integer> count = new Stack<Integer>();
        Stack<StringBuilder> res = new Stack<StringBuilder>();
        char ch[] = s.toCharArray();
        int idx = 0;
        StringBuilder currentString = new StringBuilder();

        while(idx < s.length()){

            if(Character.isDigit(ch[idx])){
                int num = 0;
                while(Character.isDigit(ch[idx])){

                    num = num*10+ (ch[idx++] - '0');

                }
                count.push(num);

            }
            else if(ch[idx] == '[')
            {
                // for the first iteration "" will be pushed
                res.push(currentString);

                currentString = new StringBuilder();
                idx++;
            }

            else if(ch[idx] == ']'){


                StringBuilder decodedString = res.pop();
                int repeatTimes = count.pop();

                for(int i = 0; i<repeatTimes; i++)
                {
                    decodedString.append(currentString);
                }

                currentString = decodedString;
                idx++;

            }
            else
            {
                currentString.append(ch[idx++]);
            }

        }
        return currentString.toString();
    }




    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decode_string(s));
    }
}
