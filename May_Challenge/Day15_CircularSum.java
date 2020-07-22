class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int len = A.length;
        // since it is a contiguous subarray , we can find the max sum and min sum and subtract the min from max to get the result
        int max_sum =Integer.MIN_VALUE,max_ending_here =0;
        int min_sum =Integer.MAX_VALUE,min_ending_here =0;
        int arr_sum=0;
        for(int i=0;i<len ;++i)
        {
            arr_sum += A[i];
            max_ending_here = max_ending_here + A[i];
            if(max_sum < max_ending_here)
            {
                max_sum = max_ending_here;
            }
            if(max_ending_here < 0)
            {
                max_ending_here =0;
            }
            min_ending_here = min_ending_here + A[i];
            if(min_sum > min_ending_here)
            {
                min_sum = min_ending_here;
            }
            if(min_ending_here > 0)
            {
                min_ending_here =0;
            }
        }
        //System.out.println("max is "+max_sum);
        if(max_sum <=0)
            return max_sum;
        return Math.max(max_sum,arr_sum-min_sum);
        
    }
}