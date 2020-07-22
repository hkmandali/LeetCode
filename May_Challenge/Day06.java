class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if(1 == len || 2 ==len)
        {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[len/2];
        
    }
}