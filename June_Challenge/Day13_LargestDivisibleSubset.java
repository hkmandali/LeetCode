class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(null == nums || 0 == nums.length)
            return ret;
        if(1 == nums.length)
        {
            ret.add(nums[0]);
            return ret;
        }
        Arrays.sort(nums);
        int len=nums.length;
        int[] div = new int[len]; // Array to store the max number of elements divisble and ending at current index     
        
        Arrays.fill(div,1);
        int max_ind = 0;
        int[] prev = new int[len]; // this is used to know the prev index for te maximum one
        Arrays.fill(prev,-1);
        for(int i=1;i<len;++i)
        {
            for(int j=0;j<i;++j)
            {
                if(nums[i] % nums[j] == 0 && (div[i] < (div[j] +1)))
                {
                    div[i] = div[j] +1;
                    prev[i] = j;
                    
                }
            }
            if(div[i] > div[max_ind])
            {
                max_ind =i;
            }
        }
        
        while(max_ind >= 0)
        {
            ret.add(nums[max_ind]);
            max_ind = prev[max_ind];
        }
        
        return ret;
    }
}