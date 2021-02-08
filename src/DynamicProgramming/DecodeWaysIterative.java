package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWaysIterative {



        Map<Integer, Integer> map = new HashMap<>();
        public int numDecodings(String s) {
            // Iterative approach

            if(s.charAt(0) == '0')
                return 0;
            int n = s.length();
            int dp[] = new int[n+1];
            dp[0] = 1;
            dp[1] = 1; // already checked in the if statement


            for(int i = 1; i<n; i++)
            {
                if(s.charAt(i) != '0')
                {
                    dp[i+1] = dp[i]; // means same as previous value
                }
                int two_digits = Integer.parseInt(s.substring(i-1, i+1));
                if(two_digits >=10 && two_digits<=26)

                {
                    dp[i+1]+=dp[i-1]; // otherwise dp[i-1] + dp[i+1], current value + previous value

                }
            }
            return dp[n];

            // Time complexity: O(n)
//            Space complexity: O(n)

        }









}
