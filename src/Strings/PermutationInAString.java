package Strings;
import java.util.Arrays;
//Given two strings s1 and s2, return true if s2 contains the permutation of s1.
//
//In other words, one of s1's permutations is the substring of s2.

//Example 1:
//
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
public class PermutationInAString {
    public boolean checkInclusion(String s1, String s2) {


        if (s2.length() < s1.length()) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        char[] ac = s1.toCharArray();
        char[] bc = s2.toCharArray();

        // FILL IN THE FREQUENCY of both
        for(int i = 0;i<ac.length;i++){
            a[ac[i]-'a']++;
            b[bc[i]-'a']++;
        }
        /// if all the characters have the same frequency in both the arrays, return true
        if(Arrays.equals(a,b)) return true;

        for(int i = ac.length;i< bc.length; i++){
            // remove the leftmost character
            b[ bc[i-ac.length]-'a']--;
            // add the new character fro right into the window
            b[ bc[i]-'a']++;
            if( Arrays.equals(a, b)) return true;
        }
        return false;
    }

}
