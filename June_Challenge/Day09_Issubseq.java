class Solution {
    /*
    boolean isSubsequenceUtil(String s,String t,int endindex1,int endindex2)
    {
        if(endindex1 < 0 || endindex2 <0)
            return false;
        if(s.charAt(endindex1) == t.charAt(endindex2)){
            if(endindex1 == 0)
                return true;
            else
                return isSubsequenceUtil(s,t,endindex1-1,endindex2-1);
        }
        return isSubsequenceUtil(s,t,endindex1,endindex2-1);
    }
    */
    public boolean isSubsequence(String s, String t) {
        
        int len =s.length();
        int len2 = t.length();
        if(s.equals(t) || len == 0)
            return true;
        if(len > len2)
            return false;
        if(len ==  len2)
        {
            return false;
        }
        // dp approach
        boolean[][] dp = new boolean[len+1][len2+1];
        dp[0][0]= true;
        for(int i=0;i<=len;++i)
        {
            for(int j=1;j<=len2;++j)
            {
                if(i == 0)
                {
                    dp[i][j] = true;
                }
                else
                {
                    if(s.charAt(i-1) == t.charAt(j-1))
                    {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else
                    {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        return dp[len][len2];
      //  return isSubsequenceUtil(s,t,len-1,len2-1);
    }
}