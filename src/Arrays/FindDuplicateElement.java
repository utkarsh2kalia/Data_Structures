package Arrays;

//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//        There is only one duplicate number in nums, return this duplicate number.
// """""In this question the array may not necessary contain all elements between 1 and n""""" eg [2,2,2,2,2] is valid
public class FindDuplicateElement {

    // this method will not work if the first element is repeated
    public static int floydtortoiseandhare(int nums[]) {
        if (nums.length <= 1)
            return -1;
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];

        }
        while (tortoise != hare);

        // Find the entrance to the cycle
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];


        }
        return hare;
    }

        public static void main (String[]args){
            int[] arr = {3, 1, 2, 4, 3};
            ;
            System.out.println(floydtortoiseandhare(arr));
        }
    }

