package Strings;

import java.util.LinkedList;

public class RemoveallAdjacentduplicates {
    class Solution {
        public String removeDuplicates(String s, int k) {
            LinkedList<Adjacent> stack = new LinkedList<>();

            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek().ch == c) {
                    stack.peek().freq++;
                } else {
                    stack.push(new Adjacent(c, 1));
                }
                if (stack.peek().freq == k) {
                    stack.pop();
                }
            }

            StringBuilder sb = new StringBuilder();
            while (stack.size() > 0) {
                Adjacent peek = stack.removeLast();
                for (int i = 0; i < peek.freq; i++) { // pop once
                    sb.append(peek.ch);
                }
            }
            return sb.toString();
        }

        class Adjacent {
            char ch;
            int freq;

            public Adjacent(char ch, int freq) {
                this.ch = ch;
                this.freq = freq;
            }
        }
    }
}
