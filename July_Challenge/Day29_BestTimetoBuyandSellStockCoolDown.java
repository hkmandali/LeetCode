class Solution {
    // we only have two states in this i.e on a single day, we can divide into two states
    /*
    1. we have a stock on that day
        a. we bought on that day  -- dp[i-2][0] - prices[i]-- sold on i-2 day - prices[i] // because 1 day cool down , then 
        b. we are just carry forwarding the previous stock -- dp[i-1][1]
    2. we dont have a stock on that day
        a. we sold on that day -- dp[i-1][1] + prices[i]
        b. we are just carry forwarding without buyinh -- dp[i-1][0]
    */
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length < 2)
            return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        
        dp[0][0]= 0; // no stock on zero day
        dp[0][1]= -prices[0]; // stock boought on that day
        dp[1][0] = Math.max(dp[0][1] + prices[1],dp[0][0]); // stock on first day -- either sold today or no stock before
        dp[1][1] = Math.max(-prices[1],dp[0][1]);
        
        for(int i=2;i<len;++i)
        {
            dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1] , dp[i-2][0]- prices[i]);
        }
        return dp[len-1][0];
    }
}