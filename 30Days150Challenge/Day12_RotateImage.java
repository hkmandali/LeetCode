public class Day12_RotateImage {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // we can transpose and then reverse to get a 90 degree rotation
        // transposing
        for(int i=0;i<row;++i)
        {
            for(int j=i+1;j<row;++j)
            {
                int temp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<row;++i)
        {
            for(int j=0;j<row/2;++j)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][row-j-1];
                matrix[i][row-j-1] = temp;
            }
        }
        return;
    }
}
