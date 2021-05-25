package InterviewBit.Arrays;

import java.util.List;

public class MaxDistance {


//    Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
public int maximumGap(final List<Integer> A) {

    int aux[] = new int[A.size()];
    int n = aux.length;
    aux[n-1] = A.get(n-1);
    for(int j = n-2; j>=0; j--){
        aux[j] = Math.max(aux[j+1], A.get(j));

    }
    int i =0, j=0,diff = Integer.MIN_VALUE;
    while(i<n && j<n)
    {
        if(aux[j]>=A.get(i))
        {
            diff = Math.max(diff, j-i);
            j++;
        }
        else
        {
            i++;
        }
    }
    return diff;



}
}
