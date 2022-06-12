class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int res=0,len= nums.length;
        HashSet<Integer> hs = new HashSet<>();
        int curr_sum=0;
        int left=0;
        for(int i=0;i<len;++i)
        {
            while(hs.contains(nums[i]))
            {
                curr_sum -= nums[left];
                hs.remove(nums[left++]);
            }
            hs.add(nums[i]);
            curr_sum += nums[i];
            res = Math.max(res,curr_sum);
        }
        return res;
    }
}