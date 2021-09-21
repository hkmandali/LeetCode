public class Day20_MatrixTicTacToe {
    public String tictactoe(int[][] moves) {
        int len = moves.length;
        if(len <= 4)
            return "Pending";
        // even moves are X , odd moves are O
        int[] rowsum = new int[3];
        int[] colsum = new int[3];
        int diag =0;
        int revdiag=0;
        int firstmove=1;
        for(int[] arr: moves)
        {
            int row = arr[0];
            int col = arr[1];
            int toadd =0;
            if(firstmove %2 ==1)
            {
                toadd = 1; // for X
            }
            else
                toadd =-1; // for O
            firstmove++;
            rowsum[row] += toadd;
            colsum[col] += toadd;

            if(row == col)
                diag += toadd;
            if(row+col == 2)
                revdiag += toadd;
        }
        //System.out.println("rev diag value is "+revdiag);
        for(int i=0;i<3;++i)
        {
            if(rowsum[i] == 3 || colsum[i] == 3 || diag == 3 || revdiag ==3)
                return "A";
            else if(rowsum[i] == -3 || colsum[i] == -3 || diag == -3 || revdiag ==-3)
                return "B";
        }
        if(len == 9)
            return "Draw";
        return "Pending";
    }
    public static void main(String[] args) {
        System.out.println("the game winner is "+new Day20_MatrixTicTacToe().tictactoe(new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},
                {2,1},{0,1},{0,2},{2,2}}));
    }
}
