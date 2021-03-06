package Arrays;

//There is an integer array nums sorted in ascending order (with distinct values).
//
//Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
//Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//Example 1:
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Example 2:
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
public class SearchInSortedRotatedArray {

        public int search(int[] nums, int target) {
            int start = 0, end = nums.length - 1;

            while(start <= end){

                int mid = start + (end - start)/2;
                if(nums[mid] == target)
                    return mid;

                else if(nums[mid] >= nums[start]) // means we are in the increasing part of array
                {
                    // check on whichside is target
                    if(target >= nums[start] && target < nums[mid])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }

                else // means middle element is smaller than start
                {
                    if(target <= nums[end] && target > nums[mid])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }


            }

            return -1;
        }

    public static void main(String[] args) {
        int[]arr = {4,5,6,7,0,1,2};
        int ans = new SearchInSortedRotatedArray().search(arr,0);
        System.out.println(ans);
    }






}
