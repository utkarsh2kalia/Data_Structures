package BitManipulation;
//Given a non-empty array of integers, every element appears
// """"""3 times""""""""" except for one,
// which appears exactly once. Find that single one.
//
//Note:
//
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//Example 1:
//
//Input: [2,2,3,2]
//Output: 3
//Example 2:
//
//Input: [0,1,0,1,0,1,99]
//Output: 99
public class SingleNumber2 {
    public int singlenumber2(int nums[])
    {
        if (nums.length <3)
        {
            return nums[0];
        }
        int seenOnce = 0, seenTwice = 0;
        for(int i = 0; i<nums.length; i++)
        {
            seenOnce = ~seenTwice & (seenOnce ^ nums[i]);
            seenTwice = ~seenOnce & (seenTwice ^ nums[i]);
        }
        return seenOnce;


    }

    public static void main(String[] args) {
        int nums[] = {0,1,0,1,0,1,99};
        SingleNumber2 obj = new SingleNumber2();
        System.out.println(obj.singlenumber2(nums));
    }
}
