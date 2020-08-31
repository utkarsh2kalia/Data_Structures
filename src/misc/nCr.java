package misc;

public class nCr {
    public static int binomial_coeff(int n, int k)
    {
        int result = 1;
        if(k > n-k)
            k = n-k;

        for(int i=0; i<k; i++)
        {
            // multiply 5,4 for k=3(20)
            result *= n-i;
            //divide by 1,2 for k=2 (20/2)
            result /= i+1;
        }
        return result;
    }
    public static void main(String[] args) {
        // program to calculate nCr using binomial coeff
        System.out.println(binomial_coeff(5,2));
    }
}
