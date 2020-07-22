class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double xdiff = (double)(coordinates[1][0] - coordinates[0][0]);
        boolean paralleltoy = false;
        double slope =0;
        if(0 == xdiff)
            paralleltoy = true;
        else
        {
          slope  = (double)(coordinates[1][1] - coordinates[0][1]) /  xdiff;
        }
         
        int len = coordinates.length;
        for(int i=2;i<len;++i)
        {
            double diffx = (double)(coordinates[i][0] - coordinates[i-1][0]) ;
            if(paralleltoy)
            {
                if(0 != diffx)
                {
                    return false;
                }
            }
            else
            {
                double slo = (double)(coordinates[i][1] - coordinates[i-1][1]) / diffx;;
                if(slo != slope)
                return false;
            }         
        }
        return true;
    }
}