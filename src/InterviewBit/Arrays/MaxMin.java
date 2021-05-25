package InterviewBit.Arrays;
//Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.
public class MaxMin {
    public int solve(int[] A) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
        for(int a:A){
        if(a>max)
            max = a;
        if(a<min)
            min = a;
    }

        return max+min;
}
}
