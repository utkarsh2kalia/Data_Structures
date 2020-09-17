package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
// this program is to generate the largest number possible from a given list of integers
public class LargestNumberformation {

    public static String largestNumber(final List<Integer> A) {


        String arr[] = new String[A.size()];
        for (int i = 0; i < A.size(); i++) {
            arr[i] = String.valueOf(A.get(i));
        }

        Arrays.sort(arr, new Comparator<String>() {

                    public int compare(String a, String b) {
                        String order1 = a + b;
                        String order2 = b + a;
                        return order2.compareTo(order1);
                    }
                }
        );
        if (arr[0].charAt(0) == '0')
            return "0";

        // use StringBuilder.append instead of + to reduce complexity
        StringBuilder ss = new StringBuilder();
        for (String s : arr) {
            ss.append(s);
        }
        return ss.toString();
    }
        public static void main (String[]args){
            List<Integer> list = Arrays.asList(5,4,1,3,0);
            System.out.println(largestNumber(list));

        }
    }
