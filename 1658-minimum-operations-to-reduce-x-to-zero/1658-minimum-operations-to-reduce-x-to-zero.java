class Solution {
    public int minOperations(int[] nums, int x) {
        int len = nums.length, res = -1;
        int left=0,right=0,total_sum=0;
        
        for(int i=0;i<len;++i)
        {
            total_sum += nums[i];
        }
        int sum=0;
        while(left < len && right < len)
        {
            sum += nums[right];
            while(left <= right && sum > total_sum -x)
            {
                sum = sum - nums[left];
                left++;
            }
            //System.out.println(" sum is. "+sum+"  left is. "+left +"  right is "+right);
            if(sum == total_sum -x) res = Math.max(res,(right-left+1));
            right++;
        }
        return res == -1 ? res : len-res;
    }
}