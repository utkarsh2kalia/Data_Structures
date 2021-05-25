package SortAndSearch;

import java.util.Arrays;

// Given An array find the total number of inversions in it. If (i < j) and a[i]> a[j] then the pair i, j is
// called inversion pair
//Input:  A[] = [1, 9, 6, 4, 5]
//
//Output: The inversion count is 5
//
//There are 5 inversions in the array: (9, 6), (9, 4), (9, 5), (6, 4), (6, 5)
public class InversionCountUsingMergeSort {

    public int merge(int arr[], int aux[],int low, int mid, int high){

        int i =low, j = mid+1, k = low;
        int inversionCount = 0;

        while(i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                // if right side is smaller
                aux[k++] = arr[j++];
                inversionCount += mid - i + 1;

            }
        }
            // copy remaining from left side
            while(i <= mid){
                aux[k++] = arr[i++];
            }

            for(i = low; i<=high; i++){
                arr[i] = aux[i];
            }
            return inversionCount;
        }



        public int mergesort(int arr[],int aux[], int low, int high){

        if(low == high){
            return 0;
        }

        int inversionCount = 0;
        int mid = low + ((high - low)>>1);

        inversionCount += mergesort(arr, aux, low, mid);
        inversionCount += mergesort(arr, aux, mid+1, high);
        inversionCount += merge(arr, aux, low, mid, high);

        return inversionCount;


        }

    public static void main(String[] args) {
        int arr[] = { 1, 9, 6, 4, 5 };
        int aux[] = Arrays.copyOf(arr, arr.length);

        System.out.println(new InversionCountUsingMergeSort().mergesort(arr, aux, 0, arr.length - 1));

    }


    }








