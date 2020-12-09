package Priorityqueue;

import java.util.*;
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

//class ElementComparator implements Comparator<Element> {
//
//    public int cmpare
//
//}

public class RearrangeElementsNoSameTwoElementsTogether {
    public static void rearange(int arr[])
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

        PriorityQueue<Map.Entry<Integer, Integer>> qu = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue() );
        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            qu.offer(entry);
        }

        List<Integer> list = new LinkedList<>();
        Map.Entry<Integer, Integer> prev = qu.poll();
        list.add(prev.getKey());
        // check if frequency is not 0is

        while(!qu.isEmpty()){

            Map.Entry<Integer, Integer> curr = qu.poll();
            list.add(curr.getKey());

            // add prev to queue if its frequency is not zero after reducing
            if(prev.getValue() >1 ) {
                prev.setValue(prev.getValue() - 1);
                qu.offer(prev);
            }

            prev = curr;
        }
        System.out.println(list);


    }

    public static void main(String[] args) {
        int arr[] = {0,0,0,8,4};
        rearange(arr);
    }




}
