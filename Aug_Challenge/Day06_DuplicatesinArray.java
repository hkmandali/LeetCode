class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList();
        if(null == nums || 0== nums.length)
            return ret;
        int len = nums.length;
        for(int i=0;i<len;++i)
        {
            int abs = Math.abs(nums[i]);
            if(nums[abs-1] < 0)
            {
                ret.add(abs);
            }
            nums[abs-1] = -nums[abs-1];
        }      
        
        return ret;
        
    }
}