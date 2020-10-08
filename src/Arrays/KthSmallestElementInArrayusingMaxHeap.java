package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Given an array find Kth smallest element in it
public class KthSmallestElementInArrayusingMaxHeap {
    public static int kthsmallestelem(List<Integer> list,int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int i = 0;i<k; i++){
            pq.add(list.get(i));
        }
        for(int i = k; i<list.size(); i++ ){
            // check if the current element isl less than the top of queue. add to queue
            if(list.get(i)<pq.peek())
            {
                pq.poll();
                pq.add(list.get(i));
            }

        }
        return pq.poll();


    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{2,1,3,1,4,5,3,2,59,977,64};
//        List<Integer>list = Arrays.asList(arr);
        System.out.println(kthsmallestelem(Arrays.asList(arr),6));
    }
}
