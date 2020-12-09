package Arrays;

public class SecondLargestElementInArray {
    public static int secondlargest(int arr[]){
        if(arr.length ==1)
            return arr[0];

        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>max) {
                max2 = max;
                max = arr[i];

            }
            else if(arr[i]>max2)
            {
                max2 = arr[i];
            }
        }
        return max2;

    }

    public static void main(String[] args) {
        int arr[] = {7,4,10,13,6,15,2,11};
        System.out.println(secondlargest(arr));
    }
}
