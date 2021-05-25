package SortAndSearch;

import java.util.Arrays;



//T(n) = T(n-1) + cn = O(n²)
//
//cn
//
//
//T(n) = 2 T(n/2) + cn = O(n.log(n))
public class QuickSort {

//    public static void swap1(int arr[], int a, int b){
//
//        // swap two numbers without using third varaible
//        arr[a] = arr[a]^arr[b];
//        System.out.println(arr[a]);
//
//        arr[b] = arr[a]^arr[b];
//        System.out.println(arr[b]);
//        arr[a] = arr[a]^arr[b];
//        System.out.println(arr[a]);
//
//
//
//    }

    public static void swap (int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int arr[], int start, int end){

        int pIndex = start;
        int pivot = arr[end];

        for(int i = start;i<end;i++ )
        {
            if(arr[i]<=pivot)
            {
                swap(arr, pIndex, i);
                pIndex++;
            }
        }
        swap(arr,pIndex,end);
        return pIndex;

    }
    public static void quicksort(int arr[], int start, int end){

        if(start>=end)
            return;

        int pivot = partition(arr, start, end);
        quicksort(arr, start, pivot-1);
        quicksort(arr, pivot+1, end);

    }


    public static void main(String[] args) {

        int arr[] = {10,30,21,100,120,40};
        quicksort(arr,0, arr.length-1);
//        swap1(arr,0,1);
//        swap1(arr,1,2);
        System.out.println(Arrays.toString(arr));
    }
}


