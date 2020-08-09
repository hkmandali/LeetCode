class Solution {
    int rottenUtil(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        int mins =0;
        int numfresh =0;
        Queue<Pair<Integer,Integer>> que = new LinkedList();
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(grid[i][j] == 2)
                {
                    que.add(new Pair(i,j));
                }
                else if(grid[i][j] ==1)
                {
                    numfresh++;
                }
            }
        }
        
        if(0 == numfresh)
            return 0;
        
        que.add(new Pair(-1,-1)); // this is used to distinguish different minutes
        
        while(!que.isEmpty())
        {
            
            boolean added = false;
            
            while(que.peek().getKey() != -1)
            {
                Pair<Integer,Integer> curr = que.poll();
                
                int x = curr.getKey();
                int y = curr.getValue();
                
                // now that we have popped the cell , we need to check if its adjacent is fresh , make it rotten and add it to the queue
                
                if(x >0 && grid[x-1][y] == 1) // top is fresh , make it rotten and add it 
                {
                    grid[x-1][y] = 2;
                    que.add(new Pair(x-1,y));
                    if(!added)
                    {
                        added = true;
                        mins++;
                    }
                }
                
                
                if(x < (row-1) && grid[x+1][y] == 1) // bottom is fresh , make it rotten and add it 
                {
                    grid[x+1][y] = 2;
                    que.add(new Pair(x+1,y));
                    if(!added)
                    {
                        added = true;
                        mins++;
                    }
                }
                
                
                if(y >0 && grid[x][y-1] == 1) // left is fresh , make it rotten and add it 
                {
                    grid[x][y-1] = 2;
                    que.add(new Pair(x,y-1));
                    if(!added)
                    {
                        added = true;
                        mins++;
                    }
                }
                
                if(y < (col-1) && grid[x][y+1] == 1) // right is fresh , make it rotten and add it 
                {
                    grid[x][y+1] = 2;
                    que.add(new Pair(x,y+1));
                    if(!added)
                    {
                        added = true;
                        mins++;
                    }
                }
                
                
            }
            
            
            que.poll(); // removing -1 and -1
            
            if(!que.isEmpty())
            {
                que.add(new Pair(-1,-1));
            }
            
        }
        
        
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        
        return mins;
    }
    public int orangesRotting(int[][] grid) {
        if(null == grid || 0 == grid.length || 0 == grid[0].length)
            return 0;
        return rottenUtil(grid);
    }
}