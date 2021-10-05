public class Day01_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1= text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;++i)
        {
            for(int j=0;j<=len2;++j)
            {
                if((i==0)||(j==0))
                    dp[i][j]=0;
                else
                {
                    if(text1.charAt(i-1) == text2.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                        //System.out.println("char is equal , dp valud is"+dp[i][j]);
                    }
                    else
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
