class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        // we cannot go top down apporach because based on the next value the prev value keeps changing , hence we come from the other way around
        for(int i=row-1;i>=0;--i)
        {
            for(int j=col-1;j>=0;--j)
            {
                if(i== row-1 && j==col-1)        
                {
                    dp[i][j] = Math.min(0,dungeon[i][j]);
                }
                else if(i == row-1)
                {
                    dp[i][j] = Math.min(0,dungeon[i][j] + dp[i][j+1]);
                }
                else if(j == col-1)
                {
                    dp[i][j] = Math.min(0,dungeon[i][j] + dp[i+1][j]);
                }
                else
                {
                    dp[i][j] = Math.min(0,dungeon[i][j] + Math.max(dp[i+1][j],dp[i][j+1]));
                }
            }
        }
        return Math.abs(dp[0][0]) +1;
    }
}