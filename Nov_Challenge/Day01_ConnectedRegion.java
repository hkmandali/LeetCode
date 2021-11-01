import java.util.Arrays;

public class Day01_ConnectedRegion {
    public void solve(char[][] board) {
        int row = board.length,col=board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int j=0;j<col;++j)
        {
            if(board[0][j] == 'O') {
                if (!visited[0][j]) // first row
                {
                    bfs(board, 0, j, visited);
                    //visited[0][j] = true;
                }
            }
            if(board[row-1][j] == 'O')
            {
                if(!visited[row-1][j]) // last row
                {
                    bfs(board,row-1,j,visited);
                    //visited[row-1][j] = true;
                }
            }
        }
        for(int i=0;i<row;++i)
        {
            if(board[i][0] == 'O') {
                if (!visited[i][0]) // first col
                {
                    bfs(board, i, 0, visited);
                    //visited[i][0] = true;
                }
            }
            if(board[i][col-1] == 'O')
            {
                if(!visited[i][col-1]) // last col
                {
                    bfs(board,i,col-1,visited);
                    //visited[i][col-1] = true;
                }
            }
        }
        System.out.println("before converting");
        for(int i=0;i<row;++i)
        {
            System.out.println(Arrays.toString(board[i]));
            for(int j=0;j<col;++j)
            {
                if(!visited[i][j])
                {
                    board[i][j] ='X';
                }
            }
        }
    }
    void bfs(char[][] board,int i,int j,boolean[][] visited)
    {
        int row = board.length;
        int col = board[0].length;
        visited[i][j] = true;
        System.out.println("index converted is");
        if(i>0 && !visited[i-1][j] && board[i-1][j] == 'O') // top
        {
            bfs(board,i-1,j,visited);
        }
        if(i<row-1 && !visited[i+1][j] && board[i+1][j] == 'O') // down
        {
            bfs(board,i+1,j,visited);
        }
        if(j>0 && !visited[i][j-1] && board[i][j-1] == 'O') // left
        {
            bfs(board,i,j-1,visited);
        }
        if(j<col-1 && !visited[i][j+1] && board[i][j+1] == 'O') // right
        {
            bfs(board,i,j+1,visited);
        }
    }
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new Day01_ConnectedRegion().solve(board);
        for(int i=0;i<board.length;++i)
        {
            System.out.println(Arrays.toString(board[i]));
        }

    }
}
