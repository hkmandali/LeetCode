import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day16 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(null == matrix || 0 == matrix.length || 0 == matrix[0].length)
        {
            return null;
        }
        List<Integer> ret = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int hor=0,ver=0;
        int i;
        while(hor < row && ver < col)
        {
            for(i = ver;i<col;++i)
            {
                System.out.println("first loop value is "+matrix[hor][i]);
                ret.add(matrix[hor][i]);
            }
            hor++;
            System.out.println("after first loop  hor is  "+hor+"  row  is  " +row +"  ver is   "+ver +"  col is  "+col);

            for(i = hor;i<row;++i)
            {
                System.out.println("second loop value is "+matrix[i][col-1]);
                ret.add(matrix[i][col-1]);
            }

            col--;
            System.out.println("after second loop  hor is  "+hor+"  row  is  " +row +"  ver is   "+ver +"  col is  "+col);
            if(hor < row) {
                for (i = col - 1; i >= ver; --i) {
                    System.out.println("third loop value is " + matrix[row - 1][i]);
                    ret.add(matrix[row - 1][i]);
                }
            }

            row--;
            System.out.println("after third loop  hor is  "+hor+"  row  is  " +row +"  ver is   "+ver +"  col is  "+col);
            if(ver < col) {
                for (i = row - 1; i >= hor; --i) {
                    System.out.println("fourth loop value is " + matrix[i][ver]);
                    ret.add(matrix[i][ver]);
                }
            }

            ver++;
            System.out.println("after fourth loop  hor is  "+hor+"  row  is  " +row +"  ver is   "+ver +"  col is  "+col);
        }


        return ret;
    }
    public static void main(String[] args) {
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println("the output is "+ Arrays.toString(new Day16().spiralOrder(input).toArray()));
    }
}
