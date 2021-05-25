package Arrays;
//You are given a read only array of n integers from 1 to n.
//
//Each integer appears exactly once except A which appears twice and B which is missing.
//
//Return A and B.
//
//Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//Note that in your output A should precede B.
//
//Example:
//
//Input:[3 1 2 5 3]
//
//Output:[3, 4]
//
//A = 3, B = 4
public class RepeatAndMissingNumber {


    public int[] repeatedNumber(final int[] a) {

        int n = a.length;
        long sum = (n / 2) * (n - 1);

        boolean visited[] = new boolean[n];

        for (int val : a) {

            visited[val % n] = !(visited[val % n]);// revert, initially false

        }
        int val1 = -1, val2 = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                if (val1 == -1)
                    val1 = (i != 0) ? i : n;
                else
                    val2 = (i != 0) ? i : n;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] == val1) {
                return new int[]{val1, val2};
            }
            if (a[i] == val2) {
                return new int[]{val2, val1};
            }

        }

        return new int[]{};
    }

    public static void main(String[] args) {

    }
}
