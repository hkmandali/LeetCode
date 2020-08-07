class Solution {
    public int numSquares(int n) {
        if(Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n)))
            return 1; // as it is a perfect square
        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;++i)
        {
            dp[i] = i;// max possible scenario when all of the numbers summed are 1
            for(int j=1;j*j <= i;++j)
            {
                dp[i] = Math.min(1+dp[i-j*j],dp[i]);
            }
        }
        return dp[n];
    }
}