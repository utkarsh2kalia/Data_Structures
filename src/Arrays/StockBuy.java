package Arrays;
import java.io.*;
import java.util.*;
public class StockBuy {





        public static void main(String[] args) throws IOException {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            int tc = Integer.parseInt(br.readLine().trim());

            while (tc-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                int[] price = new int[n];
                String[] str = br.readLine().trim().split(" ");
                for (int i = 0; i < n; i++) {
                    price[i] = Integer.parseInt(str[i]);
                }
                Solution sln = new Solution();
                sln.stockBuySell(price, n);
            }
        }
    }// } Driver Code Ends


// User function Template for Java

    class Solution {
        public void stockBuySell(int[] price, int n) {
            // code here
            int start  = 0, end = 0;
            for(int i =0; i<price.length-1; i++)
            {

                if(price[i]<price[i+1])
                {
                    end++;
                }
                else
                {
                    if(start!=end)
                        System.out.print("("+start+" "+end+") ");
                    // sell
                    start = i+1;
                    end = i+1;


                }
            }
            if(start!=end)

            {
                System.out.print("("+start+" "+end+")");
            }







        }
    }

