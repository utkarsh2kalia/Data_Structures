package Arrays;

import java.util.Arrays;
public class RearrangeAlternateHighAndLows {

// we need to swap the elements starting from the 2nd element and move 2 steps,
//    swapping is only done if
//    1. previous element is greater than the current element
//    2. the next element is greater than the current element(imp step)

    public void swap(int i, int j, int arr[])
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void rearrange(int arr[])
    {

        for(int i =1; i<arr.length; i+=2){

            // swap if previous is greater than the current as we need to start from teh smallest
            if(arr[i-1] > arr[i]){
                swap(i-1, i, arr);
            }

            if(i+1<arr.length && arr[i+1]>arr[i])
                swap(i+1, i, arr);

        }
    }


    public static void main(String[] args) {
        int arr[] = {9, 6, 8, 3, 10};
        new RearrangeAlternateHighAndLows().rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }
}
