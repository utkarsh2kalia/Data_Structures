package DynamicProgramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class ConvertStringlowercaseHackerrrank {


//    You can perform the following operations on the string, :
//
//    Capitalize zero or more of 's lowercase letters.
//    Delete all of the remaining lowercase letters in .
//    Given two strings, a and b, determine if it's possible to make a equal to  bas described. If so, print YES on a new line. Otherwise, print NO.
//
//
        static String abbreviation(String a, String b) {

            boolean[][] dp = new boolean[b.length() + 1][a.length() + 1];
            dp[0][0] = true;
            for (int j = 1; j < dp[0].length; j++) {
                if (Character.isLowerCase(a.charAt(j - 1))) dp[0][j] = dp[0][j - 1];
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    char ca = a.charAt(j - 1), cb = b.charAt(i - 1);
                    if (ca >= 'A' && ca <= 'Z') {
                        if (ca == cb) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }else {
                        ca = Character.toUpperCase(ca);
                        if (ca == cb) dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
                        else dp[i][j] = dp[i][j - 1];
                    }
                }
            }

            return dp[b.length()][a.length()] ? "YES" : "NO";

        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
           // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                String a = scanner.nextLine();

                String b = scanner.nextLine();
                // no of test cases 1
                //a=daBcd
                        //b=ABC
                String result = abbreviation(a, b);

                System.out.println(result);
            }



            scanner.close();
        }
    }


