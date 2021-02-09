package Trie;

//Question :
//        Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//        Note:
//
//        The same word in the dictionary may be reused multiple times in the segmentation.
//        You may assume the dictionary does not contain duplicate words.
//        Example 1:
//
//        Input: s = "leetcode", wordDict = ["leet", "code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
//Reference https://www.techiedelight.com/word-break-problem-using-trie/


//Check whether the string can be segmented or not


import java.util.List;
import java.util.Arrays;

class Node{

    int CHAR_SIZE = 26;
    boolean exist;
    Node[] next;

    Node(){

        next = new Node[CHAR_SIZE] ;
        exist = false; //

    }


}
public class WordBreak {


    public void insertTrie(Node head, String str){
        Node node = head;

        for(char c: str.toCharArray() ) {
            if (node.next[c - 'a'] == null)
                node.next[c - 'a'] = new Node();

            node = node.next[c - 'a'];
        }
        node.exist = true;
    }


    public boolean wordBreak(Node head, String str)
    {
        // good[i] is true if the first i characters of str can be segmented
        boolean[] good = new boolean[str.length() +1];
        good[0] = true;

        for(int i =0; i<str.length(); i++){
            if(good[i])
            {

                Node node = head;

                for (int j = i; j < str.length(); j++)
                {
                    if (node == null) {
                        break;
                    }

                    node = node.next[str.charAt(j) - 'a'];

                    // we can make [0, i] using our known decomposition,
                    // and [i+1, j] using this String in trie
                    if (node != null && node.exist) {
                        good[j + 1] = true;
                    }
                }
            }
        }
        return good[str.length()];


    }




    public static void main (String[] args)
    {
        // List of Strings to represent dictionary
        List<String> dict = Arrays.asList("this", "th", "is", "famous",
                "word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "prob", "lem");

        // use trie to store dictionary

        WordBreak wordBreak = new WordBreak();
        Node t = new Node();
        for (String word: dict) {
            wordBreak.insertTrie(t, word);
        }

        // given String
        String str = "wordbreakproblem";

        // check if String can be segmented or not
        if (wordBreak.wordBreak(t, str)) {
            System.out.println("String can be segmented");
        } else {
            System.out.println("String can't be segmented");
        }
    }







}
