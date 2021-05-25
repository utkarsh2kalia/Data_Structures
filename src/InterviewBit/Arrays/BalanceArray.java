package InterviewBit.Arrays;

import java.util.ArrayList;

public class BalanceArray {

//    Given an integer array A of size N. You need to count the number of special elements in the given array.
//
//A element is special if removal of that element make the array balanced.
//
//Array will be balanced if sum of even index element equal to sum of odd index element.
//     A = [2, 1, 6, 4]
//    After deleting 1 from array : {2,6,4}
//    (2+4) = (6)
// Hence 1 is the only special element, so count is 1

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int result = 0;
        int even = 0;
        int odd =0;

        for(int i = 0 ; i < A.size() ; i++){
            if(i%2 == 0)
                even += A.get(i);
            else
                odd += A.get(i);
        }

        int keven = 0;
        int kodd =0;

        for(int i = 0 ; i < A.size() ; i++){
            if(i%2 == 0){
                if((even - (A.get(i)+keven) + kodd) == ((odd-kodd) + keven))
                    result += 1;
                keven += A.get(i);
            }
            else{
                if((odd - (A.get(i)+kodd) + keven) == (kodd + (even-keven)))
                    result += 1;
                kodd += A.get(i);
            }
        }

        return result;
    }
}
