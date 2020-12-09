package LinkedList;
    import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

    class Result {
        HashSet<Integer> set = new HashSet<>();
        static boolean getSum(int n1)
        {
            long sum = 1;
            long n = n1;
            for (int i=2; i<=(Math.sqrt(n)); i++)
            {
                if (n%i==0)
                {
                    if (n/i == i)
                        sum = sum + i;

                    else
                    {
                        sum = sum + i;
                        sum = sum + (n / i);
                    }

                    if(sum > n)
                        return true;
                }
            }
            return false;
        }

        public static long find_plentiful_numbers(int n) {
            long sum = 0;
            for (int i = 12; i <= n; i++){
                if(n%6==0){
                    sum+=i;
                }
                else if(i%2 == 0 || i%3 == 0) {
                    if (getSum(i)) {
                        sum = (sum + i);
                    }
                }
            }

             return sum;

        }

    }

     class Solution {
        public static void main(String[] args) throws IOException {

            long output = Result.find_plentiful_numbers(1000000);
            System.out.println(output);
        }
    }
    //-777285214
// -531161482


