package Arrays;

import java.util.Arrays;

public class NextPermutation {
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int nums[], int start){

        int i = start, j = nums.length - 1;
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }



    }
    public void nextPermutation(int[] nums) {


        int i = nums.length - 2;
        while(i >=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if( i >= 0){
            int j = nums.length - 1;

            // keep on moveing until a number grater than current element is greater than
            while(nums[j] <= nums[i]){

                j--;
            }
            swap(nums, i, j);
        }

        // now from i+1 to last reverse the array
        reverse(nums, i+1);



    }

    public static void main(String[] args) {
        int nums[] = {1,5,8,4,7,6,5,3,1};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
