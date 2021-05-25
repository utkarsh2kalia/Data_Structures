package Arrays;

import java.util.stream.IntStream;

// in this method we will have all numbers except the one that is repeated
// Methods:
//1) Use xor
//2) calculate sum of all numbers, get expected sum using n*n-1/2, return expected - actual
public class DuplicateElementInArray {


    // methos 1
    public static int findDuplicateusingxor(int[] A)
    {
        int xor = 0;

        // take xor of all array elements
        for (int value : A) {
            xor ^= value;
        }

        // take xor of numbers from 1 to n-1
        for (int i = 1; i <= A.length - 1; i++) {
            xor ^= i;
        }

        // same elements will cancel out each other as a ^ a = 0,
        // 0 ^ 0 = 0 and a ^ 0 = a

        // xor will contain the missing number
        return xor;
    }


    // Method 2
    public static int findDuplicate(int[] A)
    {
        int actual_sum = IntStream.of(A).sum();
        int expected_sum = A.length * (A.length - 1) / 2;

        return actual_sum - expected_sum;
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 2 };
        System.out.println("The duplicate element using xor is " + findDuplicateusingxor(A));
        System.out.println("The duplicate element is " + findDuplicate(A));
    }
}
