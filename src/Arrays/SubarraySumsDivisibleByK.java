package Arrays;
//Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
//
//
//
//Example 1:
//
//Input: A = [4,5,0,-2,-3,1], K = 5
//Output: 7
//Explanation: There are 7 subarrays with a sum divisible by K = 5:
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//Algorithm:
// I noted above that we need to find all prefix sum pairs (i,j) such tha (p[j] - p[i]) % K == 0.
//But this is only true, if and only if p[j] % K == p[i] % K "means remainers should be equal"
//""""""""""""""""""""""""Let there be a subarray (i, j) whose sum is divisible by k
//                              sum(i, j) = sum(0, j) - sum(0, i-1)
//                      Sum for any subarray can be written as q*k + rem where q
//                                  is a quotient and rem is remainder
//                                          Thus,
                        //    sum(i, j) = (q1 * k + rem1) - (q2 * k + rem2)
                        //    sum(i, j) = (q1 - q2)k + rem1-rem2
//
//We see, for sum(i, j) i.e. for sum of any subarray to be
                                                //divisible by k, the RHS should also be divisible by k.
                                                //(q1 - q2)k is obviously divisible by k, for (rem1-rem2) to
                                                //follow the same, rem1 = rem2 where
                                                //    rem1 = Sum of subarray (0, j) % k

                                                //    rem2 = Sum of subarray (0, i-1) % k
import java.util.Arrays;
public class SubarraySumsDivisibleByK {
    // Java program to find count of
// subarrays with sum divisible by k.




        // Handles all the cases
        // function to find all sub-arrays divisible by k
        // modified to handle negative numbers as well
        static int subCount(int arr[], int n, int k)
        {

            // create auxiliary hash array to
            // count frequency of remainders
            int mod[] = new int[k];
            Arrays.fill(mod, 0);

            // Traverse original array and compute cumulative
            // sum take remainder of this current cumulative
            // sum and increase count by 1 for this remainder
            // in mod[] array
            int cumSum = 0;
            for (int i = 0; i < n; i++) {
                cumSum += arr[i];

                // as the sum can be negative, taking modulo twice
                mod[((cumSum % k) + k) % k]++;
            }

            // Initialize result
            int result = 0;

            // Traverse mod[]
            for (int i = 0; i < k; i++)

                // If there are more than one prefix subarrays
                // with a particular mod value.
                if (mod[i] > 1)
                    result += (mod[i] * (mod[i] - 1)) / 2;

            // add the elements which are divisible by k itself
            // i.e., the elements whose sum = 0
            result += mod[0];

            return result;
        }

        // Driver code
        public static void main(String[] args)
        {

            int arr[] = { 4, 5, 0, -2, -3, 1 };
            int k = 5;
            int n = arr.length;
            System.out.println(subCount(arr, n, k));
            int arr1[] = { 4, 5, 0, -12, -23, 1 };
            int k1 = 5;
            int n1 = arr1.length;
            System.out.println(subCount(arr1, n1, k1));
        }




}
