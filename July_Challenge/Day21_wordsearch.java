class Solution {
    // curr x and curr y are the current co ordinates
    // index is the one at which the current character needs to be matched
    boolean isValid(int x,int y,int row,int col)
    {
        if(x>=0 && y>=0 && x< row && y< col)
        {
            return true;
        }
        return false;
    }
    boolean found(char[][] board,int currx,int curry,int index,String word,boolean[][] visited)
    {
        if(index >= word.length())
            return false;
        
        int row=board.length;
        int col = board[0].length;
        
        // if the current character matches go for the next one 
        if(word.charAt(index) == board[currx][curry]){
        
            // all the characters match 
            if(index == word.length()-1)
                return true; 
        //left
            if(isValid(currx,curry-1,row,col) && word.charAt(index+1) == board[currx][curry-1])
            {
                if(!visited[currx][curry-1])
                {
                    visited[currx][curry-1] = true;
                    if(found(board,currx,curry-1,index+1,word,visited))
                        return true;
                    visited[currx][curry-1] = false;
                }
                
                
            }

            //right
            if(isValid(currx,curry+1,row,col) && word.charAt(index+1) == board[currx][curry+1])
            {
                if(!visited[currx][curry+1])
                {
                    visited[currx][curry+1] = true;
                    if(found(board,currx,curry+1,index+1,word,visited))
                        return true;
                    visited[currx][curry+1] = false;
                }
            }

            //top
            if(isValid(currx-1,curry,row,col) && word.charAt(index+1) == board[currx-1][curry])
            {
                if(!visited[currx-1][curry])
                {
                    visited[currx-1][curry] = true;
                    if(found(board,currx-1,curry,index+1,word,visited))
                        return true;
                    visited[currx-1][curry] = false;
                }
            }

            //bottom
            if(isValid(currx+1,curry,row,col) && word.charAt(index+1) == board[currx+1][curry])
            {
                if(!visited[currx+1][curry])
                {
                    visited[currx+1][curry] = true;
                if(found(board,currx+1,curry,index+1,word,visited))
                    return true;
                    visited[currx+1][curry] = false;
                }
            }
        }
        
        
        
        return false;
    }
    public boolean exist(char[][] board, String word) {
        if(null == board || 0 == board.length || 0 ==board[0].length)
            return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        int index =0;
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(word.charAt(0) == board[i][j])
                {
                    visited[i][j] = true;
                    if(found(board,i,j,0,word,visited))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
}