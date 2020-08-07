class Solution {
    void dfs(char[][] board,int i,int j,int row,int col)
    {
        if(i > row -1 || i< 0 || j > col -1 || j< 0)
            return;
        if(board[i][j] == 'O')
           board[i][j] = '*';
        
        if(i > 0 && board[i-1][j] == 'O')
            dfs(board,i-1,j,row,col);
        
        if(i < row -1  && board[i+1][j] == 'O')
            dfs(board,i+1,j,row,col);
        
        if(j > 0 && board[i][j-1] == 'O')
            dfs(board,i,j-1,row,col);
        
        if(j < col-1 && board[i][j+1] == 'O')
            dfs(board,i,j+1,row,col);
        return;
    }
    public void solve(char[][] board) {
        if(null == board || 0 == board.length || 0 == board[0].length)
            return;
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;++i)
        {
            if(board[i][0] == 'O') dfs(board,i,0,row,col);
            if(board[i][col-1] == 'O') dfs(board,i,col-1,row,col);
        }
        
        for(int j=0;j<col;++j)
        {
            if(board[0][j] == 'O') dfs(board,0,j,row,col);
            if(board[row-1][j] == 'O') dfs(board,row-1,j,row,col);
        }
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
        
        return;
    }
}