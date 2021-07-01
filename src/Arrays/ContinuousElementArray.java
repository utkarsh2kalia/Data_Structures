package Arrays;

import java.util.HashSet;
import java.util.Set;

public class ContinuousElementArray {

    public int continuousArray(int arr[]){

        Set<Integer> set = new HashSet<>();
        for(int val: arr)
            set.add(val);

        int max = -1;
        int currlen = 0;
        int lastnum = -1;
        int currentNum = -1;
        for(int num: set){

            if(!set.contains(num-1)){
            // means a new starting
                int currntNum = num;
                currlen = 1;

                while(set.contains(num+1)){
                    currentNum+=1;
                    currlen+=1;
                }

            }
            if(max<currlen) {
                max = currlen;
                lastnum = currentNum;

            }
        }
        int n = arr.length;
        int curr = max;
        int start = lastnum - n;
       return 0;




    }
}
