package Priorityqueue;

import java.util.PriorityQueue;
import java.util.Arrays;


//        Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
//        return the minimum number of conference rooms required.

//Example 1:
//
//Input: intervals = [[0,30],[5,10],[15,20]]
//Output: 2

public class MeetingRooms {
    public int meetingRooms(int intervals[][]){
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

    // priority Queue for storing end time, shortest end time will be on top
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    // push the first interval
        pq.add(intervals[0][1]);

        for(int i = 1; i<intervals.length; i++){

        // assign the room to new entry if the previous meeting has ended
        if(intervals[i][0] >= pq.peek())
        {
            pq.poll();
        }

        // add the new end
        pq.add(intervals[i][1]);

    }

        return pq.size();

}

    public static void main(String[] args) {
        int arr[][] = {{0,30},{5,10},{15,20}};
        System.out.println(new MeetingRooms().meetingRooms(arr));
    }
}
