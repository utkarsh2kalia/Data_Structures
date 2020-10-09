package Arrays;

public class PeakElementInArray {
    // use binary search to find peak element O(logn)
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
    public static int findPeakElement2(int[] nums) {
        if(nums.length == 1)
            return 0;

        for(int i = 0; i<nums.length-1; i++)
            if(nums[i]>nums[i+1])
                return i;
        if(nums[nums.length-1]>nums[nums.length-2])
            return nums.length-1;
        return 0;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Index:"+findPeakElement(arr)+" ");
        System.out.println("Index:"+findPeakElement2(arr)+" ");
    }
}
