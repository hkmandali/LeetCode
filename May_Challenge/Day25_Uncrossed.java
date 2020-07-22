class Solution {
    /*
    int findrecur(int[] A,int[] B,int start1,int start2,int len1,int len2)
    {
        if(start1 == len1 || start2 == len2)
        {
            return 0;
        }
        if(A[start1] == B[start2])
        {
            return 1 + findrecur(A,B,start1+1,start2+1,len1,len2);
        }
        else
        {
            return Math.max(findrecur(A,B,start1,start2+1,len1,len2),findrecur(A,B,start1+1,start2,len1,len2));
        }
    }
    */ //--> recursive approach 
    // we can observe a simple d.p that if the characters match then it is 1 + prev , else it is max of curr,prev-1 and vice versa
    public int maxUncrossedLines(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[][] ret = new int[len1+1][len2+1];
        for(int i=1;i<=len1;++i)
        {
            for(int j=1;j<=len2;++j)
            {
                if(A[i-1] == B[j-1])
                {
                    ret[i][j] = 1 + ret[i-1][j-1];
                }
                else
                {
                    ret[i][j] = Math.max(ret[i][j-1],ret[i-1][j]);
                }
            }
        }
        return ret[len1][len2];
    }
}