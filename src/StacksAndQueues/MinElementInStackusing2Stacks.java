package StacksAndQueues;

import java.util.Stack;
// the space complexity can be improved by adding a pair consisting of <value, freq> so that
// if the same value is added again and again, the value is notadded again and again to the min stack
public class MinElementInStackusing2Stacks {



        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();


        public MinElementInStackusing2Stacks() { }


        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }


        public void pop() {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }


        public int top() {
            return stack.peek();
        }


        public int getMin() {
            return minStack.peek();
        }

    public static void main(String[] args) {

    }
    }

