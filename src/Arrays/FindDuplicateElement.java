package Arrays;

public class FindDuplicateElement {

    // this method will not work if the first element is repeated
    public static int floydtortoiseandhare(int nums[]){
        if(nums.length<=1)
            return -1;
        int tortoise = nums[0];
        int hare  = nums[0];

        do{
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];

        }
        while(tortoise != hare);

        // Find the entrance to the cycle
        tortoise = nums[0];
        while(tortoise != hare){
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 5, 2, 4, 3 };;
        System.out.println(floydtortoiseandhare(arr));
    }
}
