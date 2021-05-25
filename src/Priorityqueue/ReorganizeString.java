package Priorityqueue;

//Given a string s, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
//
//If possible, output any possible result.  If not possible, return the empty string.
//
//Example 1:
//
//Input: s = "aab"
//Output: "aba"
//Example 2:
//
//Input: s = "aaab"
//Output: ""

//count letter appearance and store in hash[i]
//find the letter with largest occurence.
//put the letter into even index numbe (0, 2, 4 ...) char array
//put the rest into the array
public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        // calculate and store frequency of each alphabet
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        // find the letter with the highest frequency
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        // incase the letter is present more than half times, rearranging is not possible
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        // place the letter with highest frequency at even places
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
//        place the rest at the remaining starting with the place that we left, eg idx
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}
