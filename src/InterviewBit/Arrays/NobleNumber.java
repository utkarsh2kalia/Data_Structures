package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class NobleNumber {
//    Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.
//
//
//
//Input Format
//First and only argument is an integer array A.
//
//
//
//Output Format
//Return 1 if any such integer p is found else return -1.
//
//
//
//Example Input
//Input 1:
//
// A = [3, 2, 1, 3]
//Input 2:
//
// A = [1, 1, 3, 3]
//
//
//Example Output
//Output 1:

    public int solve(ArrayList<Integer> list) {
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            // Check if the next element is a duplicate
            if (i < list.size() - 1 && list.get(i) == list.get(i + 1)) {
                continue;
            }

            // Check if a noble int
            if (list.size() - i - 1 == list.get(i)) {
                return 1;
            }
        }

        return -1;
    }



}
