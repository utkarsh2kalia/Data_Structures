package DynamicProgramming;

import java.util.List;
import java.util.Arrays;

public class WordBreak {


    public boolean wordBreak(String s, List<String> dict, int lookup[]){



        Arrays.fill(lookup, -1);

        return check(s, dict, lookup);



    }

    public boolean check(String str, List<String> dict, int lookup[]){


        int n = str.length();
        // means that the sub problem is seen for the first time
        if(lookup[n] == -1)
        {
//            mark the problem as seen
            lookup[n] = 0;
            for(int i = 1; i<=str.length(); i++){

                String prefix  = str.substring(0, i);
                if(check(prefix, dict, lookup) && check(str.substring(i, n), dict, lookup)){

                    lookup[n] = 1;
                    return true;
                }
            }
        }
        return lookup[n] == 1;
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("this", "th", "is", "famous",
                "Word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "problem");

        // input string
        String str = "Wordbreakproblem";

        // lookup array to store solutions to subproblems
        // `lookup[i]` stores if substring `str[n-i…n)` can be segmented or not
        int[] lookup = new int[str.length() + 1];
        Arrays.fill(lookup, -1);
        WordBreak wordBreak = new WordBreak();

        if (wordBreak.wordBreak(str, dict, lookup)) {
            System.out.print("The string can be segmented");
        } else {
            System.out.print("The string can't be segmented");
        }
    }



    }



