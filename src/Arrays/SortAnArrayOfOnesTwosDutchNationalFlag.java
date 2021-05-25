package Arrays;





// we will use Dutch National Flag Algorithm that will use pivot to divide the array into
// less than pivot
// equal to pivot
// more than pivot

//
//Input: { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 }
//
//        Output:{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2 }

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class SortAnArrayOfOnesTwosDutchNationalFlag {

    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void sortUsingDutchNationalFlag(int arr[])
    {
        int start = 0;
        int end = arr.length-1;
        int pivot =1;
        int mid = 0;

        while(mid<=end){
    // node mid will noy increase in case 2
            if(arr[mid]<pivot)// current element is 0
            {
                swap(arr, mid, start);

                    start++;
                    mid++;

            }
            else if(arr[mid]>pivot)// current element is 2
            {
                swap(arr, mid, end);
                end--;
            }
            else {   // current element is 1
                ++mid;
            }


        }








    }

    public static void main(String[] args) {

        int arr[] ={ 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };
        sortUsingDutchNationalFlag(arr);
        System.out.println(Arrays.toString(arr));

    }
}
