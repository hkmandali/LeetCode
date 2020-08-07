class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int slow_ptr = nums[0];
        int fast_ptr = nums[0];
        
        slow_ptr = nums[slow_ptr];
        fast_ptr = nums[nums[fast_ptr]];
        
        while(slow_ptr != fast_ptr)
        {
            slow_ptr = nums[slow_ptr];
            fast_ptr = nums[nums[fast_ptr]];
        }
        
        int start =nums[0];
        
        while(start != slow_ptr)
        {
            start = nums[start];
            slow_ptr = nums[slow_ptr];
        }
        return slow_ptr;
    }
    
}