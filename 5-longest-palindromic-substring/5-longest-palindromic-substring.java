class Solution {
    public String longestPalindrome(String s) {
        int res=0;
        int len = s.length();
        int start=0,end=0;
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;++i )
        {
            for(int j=0;j<len-i;++j)
            {
                dp[j][j+i] = s.charAt(j) == s.charAt(j+i) && (i < 2 || dp[j+1][j+i-1]);
			if (dp[j][j+i] && i > end - start) {
				start = j;
				end = j + i;
			}
        }
    }
        return s.substring(start, end + 1);
}}