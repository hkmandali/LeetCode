class Solution {
    // first approach
    /*
    int maxdivide(int a,int b)
    {
        while(a%b == 0)
        {
            a = a/b;
        }
        return a;
    }
    boolean isUglyNum(int x)
    {
        int remaining = maxdivide(x,2);
        remaining = maxdivide(remaining,3);
        remaining = maxdivide(remaining,5);
        return (1 == remaining) ? true : false;
    }
    public int nthUglyNumber(int n) {
        
        int ret =1; 
        int count =1; 
        while(count < n)
        {
            ret++;
            if(isUglyNum(ret))
            {
                count++;
            }
        }        
        return ret;
    }
    */
    // second approach
     public int nthUglyNumber(int n) {
         int[] uglynum = new int[n];
         // this can be solved using three lists and merging them , a list for 2 ,3 ,5 separately
         // we can maintain variables for next ugly num for 2,3 5
         int next_ugly_num_2 =2,next_ugly_num_3 =3,next_ugly_num_5 =5;
         // we store the indices for the three nums separately
         int index_2=0,index_3=0,index_5=0; // these are the indices because , we take values such as 
         /*
         for 2 -- ? 1*2 , 2*2 , 3*3 , 4*2, 5*2 ...
         for 3 -- ? 1*3 , 2*3 , 3*3 , 4*3, 5*3 ...
         for 5 -- ? 1*5 , 2*5 , 3*5 , 4*5, 5*5 ...
         to maintain index of each of them we use these index_ variables
         */
         uglynum[0] =1;// first ugly num
         int i=1;
         while(i<n)
         {
             int next_ugly = Math.min(next_ugly_num_2,Math.min(next_ugly_num_3,next_ugly_num_5));
             uglynum[i]  =next_ugly;
             if(next_ugly == next_ugly_num_2) // this step is just to compare which index needs to be increased
             {
                 index_2 =index_2+ 1;
                 next_ugly_num_2 = uglynum[index_2]*2;
             }
             if(next_ugly == next_ugly_num_3)
             {
                 index_3 =index_3+ 1;
                 next_ugly_num_3 = uglynum[index_3]*3;
             }
             if(next_ugly == next_ugly_num_5)
             {
                 index_5 =index_5+ 1;
                 next_ugly_num_5 = uglynum[index_5]*5;
             }
             ++i;
         }
         return uglynum[n-1];
     }
}