package Strings;

//Question: Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
//Input: s1 = "ab" s2 = "eidbaooo"
//Output: True
//Explanation: s2 contains one permutation of s1 ("ba").
//Solution:How do we know string p is a permutation of string s? Easy, each character in p is in s too. So we can abstract all permutation strings of s to a map (Character -> Count). i.e. abba -> {a:2, b:2}. Since there are only 26 lower case letters in this problem, we can just use an array to represent the map.
//How do we know string s2 contains a permutation of s1?
// We just need to create a sliding window with length of s1, move from beginning to the end of s2.
// When a character moves in from right of the window,
// we subtract 1 to that character count from the map.
// When a character moves out from left of the window, we add 1 to that character count.
// So once we see all zeros in the map, meaning equal numbers of every characters between s1 and the substring in the sliding window, we know the answer is true.
public class PermutationPresentInString {
    public static boolean CheckIfPresent(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        //length of pattern cannot be more
        if (len1 > len2)
            return false;
        int count[] = new int[26];
        for (int i = 0; i < len1; i++) {
            // increase the count for s1
            count[s1.charAt(i) - 'a']++;
            // decrease for s2
            count[s2.charAt(i) - 'a']--;

        }
        // count if array has all zeroes signifying permutation
        if (allZeroes(count))
            return true;

        for (int i = len1; i < len2; i++) {
            // include the new character in window
            count[s2.charAt(i) - 'a']--;
            // exclude the first character of previous window
            count[s2.charAt(i - len1) - 'a']++;
            if (allZeroes(count))
                return true;


        }
        return false;
    }
        public static boolean allZeroes(int arr[]){
            for(int i= 0; i<arr.length; i++ )
            {
                if(arr[i]!=0)
                    return false;
            }
            return true;
        }


    public static void main(String[] args) {
        String s2 = "XYZZYZHSHZZ".toLowerCase();
        String s1 = "ZZY".toLowerCase();
        System.out.println(CheckIfPresent(s1,s2));
//        System.out.println('Z-');

    }

}
