package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class RearrangePositiveAndNegativeNumbers {
    public static void rearrange(int arr[]){
        int i=0,j=0, k=0;
        for(i = 0; i<arr.length; i++)
        {
            if(i%2!=0 && arr[i]<0)
                continue;
            if(i%2==0 && arr[i]>=0)
                continue;
            j=i+1;
            if(arr[i]>=0) {
                while (j < arr.length && arr[j] >= 0)
                    j++;
            }
            else
            {
                while (j < arr.length && arr[j] < 0)
                    j++;

            }
            if(j>=arr.length)
                break;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j++;

        }

    }

    public static void main(String[] args) {
        int arr[]  = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
//        IntStream.range(1,arr.length).map(i -> arr[arr.length-i]).toArray();

        rearrange(arr);
        System.out.println(Arrays.toString(arr));

    }
}
