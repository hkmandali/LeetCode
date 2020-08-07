class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left =0;
        int right = len;
        while(left < right)
        {
            int mid = left +(right-left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid;
            else 
                left= mid+1;
        }
        return left;
    }
}