package Backtracking;
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// Example 1:
// Input: n = 3
////        Output: ["((()))","(()())","(())()","()(())","()()()"]

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String > generateparen(int n){
        List<String> list = new ArrayList<>();
        if(n ==0)
            return list;
        backtrack(list, "", 0, 0 , n );
        return list;
    }
    public void backtrack(List<String> ans, String cur, int open, int close, int max ){
        if(cur.length() == 2*max){
            ans.add(cur);
            return;
        }
        if(open< max)
        backtrack(ans, cur+"(", open+1, close, max);
        if(close < open)
        backtrack(ans, cur+")", open, close+1, max);


    }


        public static void main(String args[]){
//        System.out.println("Hello");
            GenerateParenthesis obj = new GenerateParenthesis();
            System.out.println(obj.generateparen(3));

        }

    }
//    public static void main(String[] args) {
//
//        genera
//    }


