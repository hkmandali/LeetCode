class Solution {
    int res;
    boolean isSafe(int[][] board,int row,int col,int n)
    {
        for(int i=row-1;i>=0;--i)
        {
            if(board[i][col] ==1)
                return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
        {
            if(board[i][j] ==1)
                return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++)
        {
            if(board[i][j] ==1)
                return false;
        }
        return true;
    }
    void countways(int[][] board,int row,int n)
    {
        if(n == row)
        {
            res++;
            return;
        }
        for(int j=0;j<n;++j)
        {
            if(isSafe(board,row,j,n))
            {
                board[row][j]=1;
                countways(board,row+1,n);
                board[row][j]=0;
            }
        }
    }
    public int totalNQueens(int n) {
        res=0;
        int[][] board = new int[n][n];
        
        countways(board,0,n);
        return res;
    }
}