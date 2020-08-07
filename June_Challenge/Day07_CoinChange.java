class Solution {
    public int change(int amount, int[] coins) {
        if(0 == amount)
            return 1;
        if( 0 == coins.length)
            return 0;
        
        int[] dp = new int[amount+1];
        dp[0] =1;
        for(int i=0;i<coins.length;++i)
        {
            for(int j=coins[i];j<=amount;++j)
            {
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}