package Arrays;

public class FactorialOfLargeNumber {
    public static String factorial(int n){
        // stores the number of digits in the factorial
        int res[]  = new int[5000];
        // initialize the value to 1. we will store the numbers in reverse order
        res[0] = 1;
        // store the number of filled cells in the array
        int res_size = 1;

        for(int x = 2; x <= n; x++){
            res_size = multiply(x, res, res_size);
        }

        // StringBuilder to store string
        StringBuilder ss = new StringBuilder();
        for (int i = res_size-1; i>=0; i--){
            ss.append(res[i]);
        }
        return ss.toString();

    }

    public static int multiply(int x, int res[], int res_size){

         int carry = 0;

         for(int i=0; i<res_size; i++){
             int prod = x * res[i] + carry;
             res[i] = prod % 10;
             carry = prod / 10;
         }
         while(carry != 0){
             res[res_size] = carry % 10;
             carry = carry / 10;
             res_size++;


         }
         return res_size;

    }

    public static void main(String[] args) {
        System.out.println(factorial(300));
    }
}
