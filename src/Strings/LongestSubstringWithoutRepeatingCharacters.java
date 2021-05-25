package Strings;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;

        int hash[] =new int[128];
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int right =0; right<s.length(); right++){


            while(hash[s.charAt(right)] > 0)
            {
                hash[s.charAt(left)]--;
                left ++;

            }
            maxLen = Math.max(maxLen, right - left +1);
            hash[s.charAt(right)]++;


        }
        return maxLen;
    }
}
