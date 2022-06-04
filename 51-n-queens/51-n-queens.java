class Solution {
    List<List<String>> res;
    void initialize(char[][] board,int n)
    {
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                board[i][j]='.';
            }
        }
    }
    boolean isSafe(char[][] board,int row,int col,int n)
    {
        
        for(int i=0;i<row;++i)
        {
            if(board[i][col] == 'Q')
            {
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;--i,--j)
        {
            if(board[i][j]=='Q')
                return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;--i,++j)
        {
            if(board[i][j]=='Q')
                return false;
        }
        return true;
    }
    void solve(char[][] board,int row,int n){
        if(n == row)
        {
            // we need to add the current board into the results
            List<String> curr = new ArrayList<>();
            for(char[] currRow:board)
            {
                curr.add(String.valueOf(currRow));
            }
            //System.out.print
            res.add(curr);
            return;
        }
        
        for(int j=0;j<n;++j)
        {
            if(isSafe(board,row,j,n))
            {
                board[row][j]='Q';
                solve(board,row+1,n);
                board[row][j]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board =new char[n][n];
        initialize(board,n);
        res = new ArrayList<>();
        solve(board,0,n);
        
        return res;
        
    }
}