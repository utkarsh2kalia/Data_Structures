package Arrays;

import java.util.stream.IntStream;

public class ReverseAnArray {
    public static void main(String[] args) {
        int arr[]  = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        IntStream.range(1,arr.length).map(i -> arr[arr.length-i]).toArray();
    }
}
