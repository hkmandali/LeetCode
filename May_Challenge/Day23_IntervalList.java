class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
       int len1 = A.length;
        int len2 = B.length;
        if(len1 == 0|| len2 == 0)
        {
            return new int[][]{};
        }
        int i=0,j=0;
        ArrayList<int[]> obj = new ArrayList<>();
        while(i<len1 && j<len2)
        {
            if(A[i][0] >B[j][1]) // A is right to B
            {
                j++;
            }
            else if(B[j][0] > A[i][1]) // B is right to A
            {
                i++;
            }
            else if(A[i][0] == B[j][1] ) // B end and A  start match
            {
                int[] toadd = new int[2];
                toadd[0] = toadd[1] =A[i][0];
                obj.add(toadd);
                j++;
            }
            else if(A[i][1] == B[j][0] ) // A end and B start match
            {
                int[] toadd = new int[2];
                toadd[0] = toadd[1] =A[i][1];
                obj.add(toadd);
                i++;
            }
            else if(A[i][0] <= B[j][0] && A[i][1] >= B[j][1]) // B is totally inside of A
            {
                int[] toadd = new int[2];
                toadd[0] = B[j][0];
                toadd[1] =B[j][1];
                obj.add(toadd);
                j++;
            }
            else if(B[j][0] <= A[i][0] && B[j][1] >= A[i][1]) // A is totally inside of B
            {
                int[] toadd = new int[2];
                toadd[0] = A[i][0];
                toadd[1] =A[i][1];
                obj.add(toadd);
                i++;
            }
            else if(A[i][0] < B[j][0] && A[i][1] > B[j][0]) // A is to the left of B has it some part of B
            {
                int[] toadd = new int[2];
                toadd[0] = B[j][0];
                toadd[1] =A[i][1];
                obj.add(toadd);
                i++;
            }
            else // A is to the right of B and matches some part
            {
                int[] toadd = new int[2];
                toadd[0] = A[i][0];
                toadd[1] =B[j][1];
                obj.add(toadd);
                j++;
            }
        }
        int[][] ret = new int[obj.size()][2];
        for(int k=0;k<obj.size();++k)
        {
            ret[k][0] = obj.get(k)[0];
            ret[k][1] = obj.get(k)[1];
        }
        return ret;
    }
}