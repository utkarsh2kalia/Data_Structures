package Arrays;

import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;

public class NobleNumber {
    // if an array contains a number p such that there are exactly p numbers greater than p
    public static boolean noblenumber(int arr[]){

        // sort the array
        Arrays.sort(arr);

        for( int i=0; i<arr.length; i++){
            if(i < arr.length-1 && arr[i] == arr[i+1])
                continue;
            // means if the pth element from last is equal to p i.e exactly p elements are greater than p
            if(arr.length - i - 1 == arr[i] )
                return true;


        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {4,5,3,1,2,6,10};
        System.out.println((noblenumber(arr))? "Possible": "Not Possible");
    }
}
