package SortAndSearch;
import java.util.Arrays;
//What is Binary Insertion Sort?
//        We can use binary search to reduce the number of comparisons
//        in normal insertion sort. Binary Insertion Sort uses binary search to
//        find the proper location to insert the selected item at each iteration.
//        In normal insertion, sorting takes O(i) (at ith iteration) in worst case.
//        We can reduce it to O(logi) by using binary search.
//        The algorithm, as a whole, still has a running worst case running time of O(n2)
//        because of the series of swaps required for each insertion. Refer this for implementation.
public class BinaryInsertionSort {
public static void binaryinsertionsort(int arr[]){
    for(int i = 1; i<arr.length; i++){
        int x  = arr[i];
        int j = Math.abs(Arrays.binarySearch(arr,0, i, x)+1);

        System.arraycopy(arr, j, arr, j+1, i-j );
        arr[j] = x;
    }
}

    public static void main(String[] args) {
        int arr[] = {4,2,16,9,0,4,2,1,4};
        binaryinsertionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
