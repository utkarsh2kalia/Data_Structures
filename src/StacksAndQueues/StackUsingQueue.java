package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

// Takes O(n) time to push and O(1) to pop
// we keep on reverting the queue after each push which takes approximately O(n) time
public class StackUsingQueue {
    class MyStack {
        private Queue<Integer> qu = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack() {


        }

        /** Push element x onto stack. */
        public void push(int x) {
            qu.add(x);
            int size = qu.size();
            while(size>1){
                qu.add(qu.remove());
                size--;
            }

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if(!qu.isEmpty())
                return qu.remove();
            return -1;
        }

        /** Get the top element. */
        public int top() {
            return qu.peek();

        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return qu.isEmpty();
        }
    }

}
