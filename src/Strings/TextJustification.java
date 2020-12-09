package Strings;
//Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
//
//You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
//
//Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//For the last line of text, it should be left justified and no extra space is inserted between words.
//
//Note:
//
//A word is defined as a character sequence consisting of non-space characters only.
//Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//The input array words contains at least one word.
//
//
//Example 1:
//
//Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
//Output:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// https://www.youtube.com/watch?v=GqXlEbFVTXY for guidance
import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int i = 0;
        int n = words.length;

        while (i < n) {
            int j = i + 1;
            int wordLength = words[i].length();

            while (j < n && (wordLength + words[j].length() + (j - i - 1)) < maxWidth) {
                wordLength += words[j].length();
                j++;
            }

            int wordsTotal = j - i;
            int wordDiff = maxWidth - wordLength;

            if (wordsTotal == 1 || j >= n) res.add(leftJustify(words, i, j, wordDiff));
            else res.add(middleJustify(words, i, j, wordDiff));

            i = j;
        }
        return res;
    }

    public String leftJustify(String[] words, int i, int j, int wordDiff) {
        int spaces = j - i - 1;
        int rightSpaces = wordDiff - spaces;

        StringBuilder sb = new StringBuilder(words[i]);
        for (int w = i + 1; w < j; w++) {
            sb.append(" ");
            sb.append(words[w]);
        }
        sb.append(" ".repeat(rightSpaces));
        return sb.toString();
    }

    public String middleJustify(String[] words, int i, int j, int wordDiff) {
        int spacesNeeded = j - i - 1;
        int spacePerWord = wordDiff / spacesNeeded;
        int extraSpaces = wordDiff % spacesNeeded;

        StringBuilder sb = new StringBuilder(words[i]);
        for (int w = i + 1; w < j; w++) {
            int space = spacePerWord;

            if (extraSpaces > 0) {
                space += 1;
                extraSpaces--;
            }

            sb.append(" ".repeat(space));
            sb.append(words[w]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }



}
