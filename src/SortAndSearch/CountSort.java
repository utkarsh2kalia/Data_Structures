package SortAndSearch;

// TIme Complexity: O(n)
// used only when a range of values are given(means all the numbers in an array should be in a given range)

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// In this method we find the frequency of each element and then store them in an array
public class CountSort {

    public int[] countingSort()throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // number of integers
        int n = Integer.parseInt(br.readLine());
        int nums[] = new int[n];
        // enter  numbers
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++)
        {
            nums[i] = Integer.parseInt(st.nextToken());
            max = Integer.max(max, nums[i]);
        }
        // aux should be equal to the maximum value in the array (if a range is given)
        int aux[] = new int[max+1];
        for(int i = 0; i<n; i++ )
            aux[nums[i]]++;
        int result[] = new int[n];
        int cc = 0;
        for(int i =1; i<aux.length; i++){
            if(aux[i]!=0)
            {
                while(aux[i]!=0){
                    result[cc++] = i;
                    aux[i]--;

                }
            }

        }
       return result;


    }


    public static void main(String[] args) {
        int arr[] = {6,5,4,9,7,10,14,30,12};
        CountSort countSort = new CountSort();
        try {
            Arrays.stream(countSort.countingSort()).forEach(value -> System.out.print(value + " "));
        }
        catch (Exception e){
            System.out.println("IO error");
        }
    }
}
