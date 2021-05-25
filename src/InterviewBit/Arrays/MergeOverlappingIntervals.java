package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

//Given a collection of intervals, merge all overlapping intervals.
//
//For example:
//
//Given [1,3],[2,6],[8,10],[15,18],
//
//return [1,6],[8,10],[15,18].
//
//Make sure the returned intervals are sorted.
class Interval {
      int start;
     int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }
public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {


        Collections.sort(intervals, (a, b)->a.start - b.start);
        LinkedList<Interval> list = new LinkedList<Interval>();
        for(Interval interval: intervals){

            if(list.isEmpty()||list.getLast().end<interval.end)
            {
                list.add(interval);

            }
            else
            {
                list.getLast().end = Math.max(interval.end,list.getLast().end);
            }




        }
        return new ArrayList<Interval>(list);



    }
}
