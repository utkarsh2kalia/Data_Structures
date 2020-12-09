package Priorityqueue;

import java.util.*;

class Element {
    int freq;
    int val;

    Element(int freq, int val) {
        this.freq = freq;
        this.val = val;
    }
}
public class No2SameElementsAdjacent {



// consider elements in any range in this case
// for numbers in range 0-9 we can use an array instead of a hashmap to reduce space complexity

    //Given an array of integers. The task is to rearrange elements of the array such that
//        no two adjacent elements in the array are same.
//
//        Examples:
//
//        Input: arr[] = {1, 1, 1, 2, 2, 2}
//        Output: {2, 1, 2, 1, 2, 1}
//       Input: {0,0,0,8,4}
//      Out: {0,8,0,4,0}



        public static void rearange1(int arr[])
        {

            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i<arr.length; i++)
            {
                if(!map.containsKey(arr[i]))
                    map.put(arr[i], 1);
                else
                {
                    map.put(arr[i],map.get(arr[i])+1);
                }
            }

            PriorityQueue<int[]> qu = new PriorityQueue<>((a, b)-> b[1] - a[1] );
            for(Map.Entry<Integer, Integer> entry: map.entrySet())
            {
                qu.offer(new int[]{entry.getKey(), entry.getValue()});
            }

            List<Integer> list = new LinkedList<>();
            int []prev = qu.poll();
            list.add(prev[0]);
            // check if frequency is not 0is

            while(!qu.isEmpty()){

                int []curr = qu.poll();
                list.add(curr[0]);

                // add prev to queue if its frequency is not zero after reducing
                if(prev[1] >1 ) {
                    prev[1] -= 1;
                    qu.offer(prev);
                }

                prev = curr;
            }
            System.out.println(list);


        }

        public static void main(String[] args) {
            int arr[] = {0,0,0,8,4};
            rearange1(arr);
        }




    }


