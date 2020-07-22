class Solution {
    public int countSquares(int[][] matrix) {
        int count =0;
        if(null == matrix || 0 == matrix.length || 0 == matrix[0].length)
        {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(i==0 || j==0)
                {
                    count += matrix[i][j];
                }
                else
                {
                    if(0 != matrix[i][j])
                    {
                        
                        int min =Math.min(matrix[i-1][j-1] ,Math.min(matrix[i-1][j],matrix[i][j-1]));
                        matrix[i][j] = 1+min;
                        count+=matrix[i][j];
                    }
                }
            }
        }
        return count;
    }
}