package InterviewBit.Arrays;

import java.util.Comparator;
import java.util.List;

//Given a list of non negative integers, arrange them such that they form the largest number.
//
//For example:
//
//Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
import java.util.Arrays;
public class LargestNumber {


    public String largestNumber(final List<Integer> A) {
        String arr[] = new String[A.size()];
        for(int i = 0;i< A.size(); i++){
            arr[i] =String.valueOf(A.get(i));
        }

        Arrays.sort(arr, new Comparator
                <String>(){

            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }}
        );
        if(arr[0].charAt(0)=='0')
            return "0";
        StringBuilder ss = new StringBuilder();
        for(String s: arr){
            ss.append(s);
        }
        return ss.toString();
    }
}

