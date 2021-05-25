package Strings;
//Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

//Example 1:
//
//Input: s = "eceba", k = 2
//Output: 3
//Explanation: The substring is "ece" with length 3.
public class LongestSubstringWithAtmostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int dis = 0;
        int res = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            // if the frequency of the character is zero, it means that the character is unique in the currentwindow
            if (count[s.charAt(j)]++ == 0) dis++;
            // calculate the maximum length if the distinct characters are less than = k
            if (dis <= k)
                res = Math.max(res,(j - i + 1));

//            take the leftmost character and decrease its frequency (means move it out of the window)
            while (dis > k) {
                // reove the leftmost character from the window
                --count[s.charAt(i)];
                if(count[s.charAt(i)] == 0)
                {
                    // if the frequency is 0, decrease distinct character
                    dis--;
                }

                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtmostKDistinctCharacters().lengthOfLongestSubstringKDistinct("eceba", 2));
    }

}
