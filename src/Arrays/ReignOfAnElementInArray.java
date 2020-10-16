package Arrays;

import java.util.Stack;

public class ReignOfAnElementInArray {
    public static void reign(int arr[]) {
        int l = arr.length;
        if (l == 1) {
            System.out.println(arr[1] + " 1:1");
            return;
        }
        Stack<Integer> nstack = new Stack<>();
        Stack<Integer> istack = new Stack<>();


        // push the first element;
        int index = 1, i;
        nstack.push(arr[index]);
        istack.push(index);
        for (i = 2; i < l; i++) {
            // if current number is greater than the current number, pop
            if (nstack.peek() < arr[i]) {

                // pop and print its reign
                System.out.println(nstack.pop() + ":" + istack.peek() + " " + (i - 1));
                //store its index as it may be required in case the next element is smaller
                index = istack.pop();

                while (!nstack.isEmpty() && nstack.peek() < arr[i]) {


                    System.out.println(nstack.pop() + ":" + istack.peek() + " " + (i - 1));
                    index = istack.pop();


                }
                nstack.push(arr[i]);
                istack.push(index);
            } else {
                nstack.push(arr[i]);
                istack.push(i);
            }
        }
        // for the remaining elements in array
        while (!nstack.isEmpty() && !istack.isEmpty()) {
            System.out.println(nstack.pop()+":"+istack.pop()+" "+(i-1));


        }
    }

    public static void main(String[] args) {
        int arr[] = {0,8,9,5,4,2,6,7,1,5};
        reign(arr);
    }
}
