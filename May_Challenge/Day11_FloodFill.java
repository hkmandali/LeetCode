class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        Queue<Pair> nodes = new LinkedList<>();
        Pair start = new Pair<>(sr,sc);
        int srcColor = image[sr][sc];
        nodes.add(start);
        boolean[][] visited = new boolean[row][col];
        while(!nodes.isEmpty())
        {
            Pair<Integer,Integer> pop = nodes.poll();
            int x = pop.getKey();
            int y = pop.getValue();
            image[x][y] =newColor;
            if(x-1 >= 0) // top
            {
                if(!visited[x-1][y])
                {
                    if(image[x-1][y] == srcColor)
                    {
                        nodes.add(new Pair(x-1,y));
                        visited[x-1][y] = true;
                    }
                }
            }
            if(y-1 >= 0)// left
            {
                if(!visited[x][y-1])
                {
                    if(image[x][y-1] == srcColor)
                    {
                        nodes.add(new Pair(x,y-1));
                        visited[x][y-1] = true;
                    }
                }
            }
            if(x+1 < row) // bottom
            {
                if(!visited[x+1][y])
                {
                    if(image[x+1][y] == srcColor)
                    {
                        nodes.add(new Pair(x+1,y));
                        visited[x+1][y] = true;
                    }
                }
            }
            if(y+1 < col)
            {
                if(!visited[x][y+1])
                {
                    if(image[x][y+1] == srcColor)
                    {
                        nodes.add(new Pair(x,y+1));
                        visited[x][y+1] = true;
                    }
                }
            }
        }
        return image;
    }
}