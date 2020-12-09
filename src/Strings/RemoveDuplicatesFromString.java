package Strings;
//Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
//
//We repeatedly make duplicate removals on S until we no longer can.
//
//Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
//
//
//
//Example 1:
//
//Input: "abbaca"
//Output: "ca"
public class RemoveDuplicatesFromString {

    public String removeDuplicates(String S) {
        char[] arr=S.toCharArray();
        int i=0;
        for(char c:arr){
            if(i>0 && c==arr[i-1]){
                i--;
            }
            else{
                arr[i]=c;
                i++;
            }
        }
        return new String(arr,0,i);

    }
    public static String removeDuplicates(char[] chars)
    {
        char prev = '\0';
        int k = 0;

        for (char c: chars) {
            if (prev != c) {
                chars[k++] = c;
                prev = c;
            }
        }

        return new String(chars).substring(0, k);
    }

}
