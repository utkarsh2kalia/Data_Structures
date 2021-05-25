package Strings;
//Given two strings s and t of lengths m and n respectively, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
//
//Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

//Example 1:
//
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for(int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        String result = "";
        int left = 0, minLength = s.length() + 1, count = 0;

        for(int right = 0; right < s.length(); right++) {
            if (hash[s.charAt(right)] > 0) {
                count++;
            }
            hash[s.charAt(right)]--;

            while (hash[s.charAt(left)] < 0 && left < right) {
                hash[s.charAt(left)]++;
                left++;
            }
            if(count == t.length() && right - left + 1 < minLength) {
                result = s.substring(left, right + 1);
                minLength = right - left + 1;
            }

        }
        return result;
    }
}
