class Solution {
    public int islandPerimeter(int[][] grid) {
        int totalsquare =0;
        int adjacent =0;
        int row = grid.length;
        int col = grid[0].length;
        // here we are calculating the num of squares (totalsquare) and subtracting adjacent from that by checking left and top
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(grid[i][j] == 1) // we need to calculate only occupied cells
                {
                    totalsquare++;
                    if(i> 0 && grid[i-1][j] ==1 ) // top
                    {
                        adjacent++;
                    }
                    if(j>0 && grid[i][j-1] ==1 ) // left
                    {
                        adjacent++;
                    }
                }
            }
        }
        return totalsquare*4 - adjacent*2;
    }
}