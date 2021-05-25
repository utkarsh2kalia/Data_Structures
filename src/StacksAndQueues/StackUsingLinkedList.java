package StacksAndQueues;

public class StackUsingLinkedList {
    class StackNode
    {
        int data;
        StackNode next;
        StackNode(int a)
        {
            data = a;
            next = null;
        }
    }



        // Note that top is by default null
        // in Java
        StackNode top;

        void push(int a) {

            StackNode node = new StackNode(a);
            node.next = top;
            top = node;


            // Add your code here
        }
        int pop() {
            // Add your code here
            if(top!=null)
            {
                int num = top.data;
                top = top.next;
                return num;
            }
            return -1;
        }

    public static void main(String[] args) {
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        stackUsingLinkedList.push(100);
        stackUsingLinkedList.push(2000);
        System.out.println(stackUsingLinkedList.pop());

    }


    }




