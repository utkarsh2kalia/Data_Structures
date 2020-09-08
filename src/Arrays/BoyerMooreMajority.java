package Arrays;

import java.util.Scanner;

public class BoyerMooreMajority {
    public static int findmajorityelement(int arr[]){
        int m = -1; //majority element
        int i = 0; // counter element

        for(int j=0; j<arr.length; j++){
            if(i==0){
                m = arr[j];
                i = 1;
            }
            else if(m == arr[j]){
                i+=1;

            }
            else{
                i--;
            }

        }
        return m;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[]={3,3,3,2,6,3,7,3};
        System.out.print(findmajorityelement(arr));
    }
}
