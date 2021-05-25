package StacksAndQueues;

public class AdjacentDuplicates {
    // this method is more faster than the stack method
    public String removeDuplicates(String S) {
        int i = 0;
        char[] arr = S.toCharArray ();

        for (char c : arr) {
            arr[i] = c;
            if (i > 0 && arr[i - 1] == c) {
                --i;
            }
            else {
                ++i;
            }
        }

        return new String (arr, 0, i);
    }
}
