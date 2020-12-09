package Arrays;
//Amazon Question
// In a list of songs, the i-th song has a duration of time[i] seconds.
//
//Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
//
//
//
//Example 1:
//
//Input: [30,20,150,100,40]
//Output: 3
//Explanation: Three pairs have a total duration divisible by 60:
//(time[0] = 30, time[2] = 150): total duration 180
//(time[1] = 20, time[3] = 100): total duration 120
//(time[1] = 20, time[4] = 40): total duration 60
//Example 2:
//
//Input: [60,60,60]
//Output: 3
//Explanation: All three pairs have a total duration of 120, which is divisible by 60.
//
//
//Note:
//
//1 <= time.length <= 60000
//1 <= time[i] <= 500
public class PairsOfSongsWithTotalDurationDIVBy60 {

    public static int numPairsDivisibleBy60(int[] time) {
        int reminders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += reminders[0];
            } else { // check if a%60+b%60==60
                count += reminders[60 - t % 60];
            }
            reminders[t % 60]++; // reminder to update the reminders
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {30,20,150,100,40};
        System.out.print(numPairsDivisibleBy60(arr));
    }
}
