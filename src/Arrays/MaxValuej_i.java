package Arrays;


import java.util.ArrayList;
import java.util.List;

    //Find the maximum value of `j – i` such that `A[j] >= A[i]` in an array
//Input:
//N = 9
//A[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
//Output:
//6
//Explanation:
//In the given array A[1] < A[7]
//satisfying the required
//condition(A[i] <= A[j]) thus giving
//the maximum difference of j - i
//which is 6(7-1).
public class MaxValuej_i {
    static int maxIndexDiff(int arr[], int n) {

        // Your code here
        int aux[] = new int[arr.length];
        aux[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            aux[j] = Math.max(arr[j], aux[j + 1]);
        }
        int diff = Integer.MIN_VALUE;
        for (int i = 0, j = 0; j < n && i < n; ) {

            if (arr[i] <= aux[j]) {
                diff = Math.max(j - i, diff);
                j++;
            } else {
                i++;
            }

        }
        return 0;


    }

    public static void main(String[] args) {
        int arr[] ={1,2,3,4,5};
        System.out.println(arr instanceof Object);
        String s = "gello";
        System.out.println(s.replace('g','h'));


    };

}
