package InterviewBit.Arrays;

import java.util.List;

public class N3RepeatNumber {
//    You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
//
//If so, return the integer. If not, return -1.
public int repeatedNumber(final List<Integer> a) {
    Integer candidate1 = null;
    Integer candidate2 = null;
    int n = a.size();
    int count1 = 0, count2 = 0;
    for(int i =0; i<a.size(); i++)
    {
        int num = a.get(i);
        if(candidate1!=null && candidate1 ==num)
        {
            count1++;
        }
        else if(candidate2!=null && candidate2 ==num)
        {
            count2++;
        }
        else if(count1<=0)
        {
            candidate1 = num;
            count1++;
        }
        else if(count2<=0)
        {
            candidate2 = num;
            count2++;
        }
        else
        {
            count1--;
            count2--;

        }
    }
    count1=0;count2=0;
    for(int val:a)
    {
        if(candidate1!=null && val==candidate1)

            count1++;

        if(candidate2!=null && val==candidate2)
            count2++;
    }
    // System.out.print(candidate1+" "+candidate2+" "+n+" "+count1+" "+count2);
    if(count1 > n/3)
        return (int)candidate1;
    if(count2 > n/3)
        return (int)candidate2;

    return -1;

}}
