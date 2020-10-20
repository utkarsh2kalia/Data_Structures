package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// the program is for 0, but we can make it work for any sum

public class Array3sum {
    public static List<List<Integer>> sum3(int arr[])
    {
        List<List<Integer>> list = new LinkedList<>();
        int l = arr.length;
        Arrays.sort(arr);
        for(int i = 0 ;i < l-2; i++ ){
            // condition for duplicate elements
            if(i!=0 && arr[i]==arr[i-1]  )
                continue;
            int low = i+1;
            int high = l-1;

            while (low < high)
             {
                 int target = arr[high]+arr[low]+arr[i];
                if( target == 0)// or k
                {
                    list.add(new ArrayList<>(Arrays.asList(arr[low], arr[high], arr[i])));
                    high--;
                    low++;
                    // for duplicate results
                    while(low<high && arr[i] == arr[i-1])
                        i++;
                }
                else if(target <0)
                    low++;
                else
                    high--;

            }

        }
        return list;

    }

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        System.out.println(sum3(arr));
    }



}
