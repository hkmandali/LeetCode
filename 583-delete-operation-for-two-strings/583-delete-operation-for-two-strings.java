class Solution {
    public int minDistance(String word1, String word2) {
        int res =0;
        if(word1.equals(word2))
            return res;
        int len1 = word1.length(),len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;++i)
        {
            for(int j=0;j<=len2;++j)
            {
                if(0 == i)
                {
                    dp[i][j]=j;
                }
                else if(0 == j)
                {
                    dp[i][j]= i;
                }
                else
                {
                    if(word1.charAt(i-1) == word2.charAt(j-1))
                    {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else
                        dp[i][j] = 1 + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}