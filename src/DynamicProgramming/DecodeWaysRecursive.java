package DynamicProgramming;
//
//A message containing letters from A-Z can be encoded into numbers using the following mapping:
//
//        'A' -> "1"
//        'B' -> "2"
//        ...
//        'Z' -> "26"
//        To decode an encoded message, all the digits must be mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "111" can have each of its "1"s be mapped into 'A's to make "AAA", or it could be mapped to "11" and "1" ('K' and 'A' respectively) to make "KA". Note that "06" cannot be mapped into 'F' since "6" is different from "06".
//
//        Given a non-empty string num containing only digits, return the number of ways to decode it.
//
//        The answer is guaranteed to fit in a 32-bit integer.
//
//
//
//        Example 1:
//
//        Input: s = "12"
//        Output: 2
//        Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

import java.util.HashMap;
import java.util.Map;

public class DecodeWaysRecursive {

    Map<Integer, Integer> map = new HashMap<>();
    public int ways(String s){

        return recursive(0, s);

    }

    private int recursive(int i, String s) {
        if(map.containsKey(i))
            return map.get(i);
        if(i == s.length())
           return 1;
        if (s.charAt(i) == '0')
            return 0;
        if (i == s.length() - 1)
            return 1;
        int ans = recursive(i+1, s);
        if(Integer.parseInt(s.substring(i, i+2)) <= 26)
            ans += recursive(i+2, s);

        map.put(i, ans);
        return ans;





    }

    public static void main(String[] args) {
        String s = "12";
        DecodeWaysRecursive decodeWaysRecursive = new DecodeWaysRecursive();
        System.out.println(decodeWaysRecursive.ways(s));
    }

    // time; O(n)
//       space: O(n)

}
