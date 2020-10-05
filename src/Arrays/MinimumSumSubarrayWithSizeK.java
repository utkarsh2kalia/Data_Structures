package Arrays;

public class MinimumSumSubarrayWithSizeK {

    // create a window
    public static int minimumsum(int arr[], int k){

        int window_sum =0;
        int min = Integer.MAX_VALUE;
        int last = 0;// stores index of ending index
        for(int i =0; i<arr.length; i++){
            window_sum += arr[i];
            if(i+1 >= k){
                if(min>window_sum)
                {
                    min = window_sum;
                    last = i;

                }
                window_sum -= arr[i - k+1];
            }
        }

            System.out.println("Sum = "+min);
            return last;

    }

    public static void main(String[] args) {
        int arr[] = {1,3,4,6,4,2,2,53,2,1,4,5};
        System.out.println("Subarray ending at "+minimumsum(arr,3));
    }


    }


