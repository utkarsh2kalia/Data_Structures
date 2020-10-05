package Arrays;

public class CheckIfArrayIsAMaxHeap {
    // Java program to check whether a given array
// represents a max-heap or not



        // Returns true if arr[i..n-1] represents a
// max-heap
        static boolean isHeap(int arr[], int n) {
            // Start from root and go till the last internal
            // node
            for (int i = 0; i <= (n - 2) / 2; i++) {
                // If left child is greater, return false
                if (arr[2 * i + 1] > arr[i]) {
                    return false;
                }

                // If right child is greater, return false
                if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
                    return false;
                }
            }
            return true;
        }

        // Driver program
        public static void main(String[] args) {
            int arr[] = {90, 15, 10, 7, 12, 2, 7, 3};
            int n = arr.length;
            if (isHeap(arr, n)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }


}
