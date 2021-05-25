package Strings;
//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.
//
//
//
//Example 1:
//
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {

        int []hash = new int[256];
        int right = 0, left = 0; int maxchar = 0;

        for(right = 0; right < s.length(); right++){
            // store the maximum frequency
            maxchar = Math.max(maxchar, ++hash[s.charAt(right)]);
            // if the number of maxchar and others is greater than k move left
            while(right - left + 1 - maxchar > k)
            {
                hash[s.charAt(left)]--;
                left++;
            }



        }
        // either equal to maxchar+k or the length of teh string if all the characters are already equal
        return  Math.min(maxchar+k, s.length());
    }

}
