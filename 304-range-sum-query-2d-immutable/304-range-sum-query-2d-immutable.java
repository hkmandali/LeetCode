class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];
        for(int i=0;i<row;++i)
        {
            int sum=0;
            for(int j=0;j<col;++j)
            {
                dp[i][j] = sum+matrix[i][j];
                sum = dp[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=0;
        for(int i=row1;i<=row2;++i)
        {
            res += dp[i][col2];
            if(col1 > 0)
            {
                res -= dp[i][col1-1];
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */