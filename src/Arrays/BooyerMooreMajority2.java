package Arrays;

//To figure out a O(1)O(1) space requirement, we would need to get this simple intuition first. For an array of length n:
//
//There can be at most one majority element which is more than ⌊n/2⌋ times.
//There can be at most two majority elements which are more than ⌊n/3⌋ times.
//There can be at most three majority elements which are more than ⌊n/4⌋ times.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BooyerMooreMajority2 {
    public static List<Integer> findmajorityelement2(int arr[]){
        // initialize the elements
        int count1 = 0;
        int count2 = 0;

        // candidates
        Integer candidate1 = null;
        Integer candidate2 = null;

        for(int num: arr ){
            if(candidate1 != null && candidate1 == num){
//                candidate1 = num;
                count1++;
            }
            else if(candidate2 != null && candidate2 == num){
//                candidate2 = num;
                count2++;
            }
            else if(count1 == 0){
                count1++;
                candidate1 = num;
            }
            else if(count2 == 0){
                count2++;
                candidate2 = num;
            }
            else{
                count1--;
                count2--;

            }
        }
        // confirm whether count1 and count2 are greater than n/3
        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;

        for(int num: arr){
            if(candidate1 != null && candidate1 == num) count1++;
            if(candidate2 != null && candidate2 == num) count2++;
        }
        int n = arr.length;
        if(count1>n/3) result.add(candidate1);
        if (count2>n/3) result.add(candidate2);
        return result;

    }

    public static void main(String[] args) {
        int arr[] = {1,1,1,3,3,2,2,2};
        System.out.println(findmajorityelement2(arr));
    }
}
