package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Peak {
    public static int perfectPeak(List<Integer> A) {

        int arr[] = new int[A.size()];
        for(int i = 0; i<arr.length; i++)
            arr[i] = A.get(i);
        int n = arr.length;
        int left[] = new int[A.size()];
        int right[] = new int[A.size()];
        left[0] = arr[0];
        left[1] = arr[0];
        right[n-2] = arr[n-1];
        for(int i = 2; i<arr.length; i++)
        {
            left[i] = Math.max(left[i-1], arr[i-1]);
            right[n-i-1] = Math.min(right[n-i], arr[n-i]);

        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for(int i = 1; i<arr.length-1; i++)
        {
            if(arr[i]>left[i] && arr[i]<right[i])
                return 1;
        }
        return 0;
        // search(arr, 0, a.length-1);



    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

    public static void main(String[] args) {
        perfectPeak(Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9));
    }
}
