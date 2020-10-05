package Arrays;

import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

public class ReplaceEachEleemntWithItsRankInArray {
// Use TreeMap
    public static void transform(int[] arr)
    {
        // create an empty TreeMap
        Map<Integer, Integer> map = new TreeMap<>();

        // store (element, index) pair in TreeMap
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        // keys are stored in sorted order in TreeMap

        // rank starts from 1
        int rank = 1;

        // iterate through the map and replace each element by its rank
        for (var val : map.values()) {
            arr[val] = rank++;
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 10, 8, 15, 12, 6, 20, 1 };

        // transform the array
        transform(A);

        // print the transformed array
        System.out.println(Arrays.toString(A));
    }
}
