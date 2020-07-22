class Solution {
    // this is a bipartite graph coloring problem , we first need to construct the graph else there can be issue on breaking components, we can construct the adjacent list / matrix , we'll see through matrix now
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int len = dislikes.length;
        boolean[][] adjmatr = new boolean[N][N];
        for(int i=0;i<dislikes.length;++i)
        {
            adjmatr[dislikes[i][0] -1 ][dislikes[i][1] -1] =true; // adj matrix
            adjmatr[dislikes[i][1] -1 ][dislikes[i][0] -1] =true; 
        }
        int[] colour = new int[N]; // colour for the vertices , 1 --> group 1 , -1 --> group 2
        // 0 --> not coloured yet
        for(int i=0;i<N;++i)
        {
            if(colour[i] == 0 && !dfs(N,adjmatr,colour,1,i))
                return false;
        }
        
        
        return true;
    }
    
    // maxNodes , adjacency matrix , colour of vertices , colour to be assigned --> we pass 1 when starting, current vertex
    boolean dfs(int N,boolean[][] adjmatr,int[] colourarray,int color,int currentvertex)
    {
        
        //colourarray[currentvertex] = color;
        /*
        if(colourarray[currentvertex] != 0 )
            return colourarray[currentvertex] == color; // this checks if the colour is valid or not
        */
        colourarray[currentvertex] = color;
        for(int i=0;i<N;++i)
        {
            if(adjmatr[currentvertex][i])
            {
                if(colourarray[i] == color)
                    return false; // adjacent is same colour
                if(colourarray[i] == 0 && !dfs(N,adjmatr,colourarray,-1*color,i))
                    return false;
            }
        }
        return true;
        
        
    }
}