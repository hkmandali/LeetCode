https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3426/
class Solution {
    public int maxProfit(int[] prices) {
        if(null == prices || 0 == prices.length)
            return 0;
        int max_profit =0;
        int len = prices.length;
        if(len < 2)
            return 0;
        int min = prices[0];
        int max = prices[len-1];
        int[] p1 = new int[len]; // p1[i] contains the profit when sold at i  , which is bought atmost 1 time
        int[] p2 = new int[len]; // p2[i] contains the profit when bought at i , which is bought atmost 1 time
        // hence we need to find the max of p1[i] and p2[i+1]
        for(int i=1;i<len;++i)
        {
            p1[i] = Math.max(p1[i-1],prices[i]-min);
            min = Math.min(min,prices[i]);
            
            int j = len-i-1;
            p2[j] = Math.max(p2[j+1],max-prices[j]);
            max= Math.max(max,prices[j]);
                
        }
        for(int i=0;i<len;++i)
        {
            if(i== len-1)
            {
                max_profit = Math.max(max_profit , p1[i]);
            }
            else
                max_profit = Math.max(max_profit , p1[i] + p2[i+1]);
        }
        
        return max_profit;
    }
}