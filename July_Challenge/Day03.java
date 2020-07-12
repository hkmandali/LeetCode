class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int res_day = (N-1)%14 +1; // the given cycle repeats after 14 days
        
        for(int i=0;i<res_day;++i)
        {
            int[] res = new int[8]; // length is fixed
            for(int j=0;j<8;++j)
            {
                if(0 == j|| 7 == j) // first and last columns are always zero
                {
                    res[j] = 0; // they wont get changed
                }
                else
                {
                    if(cells[j-1] == cells[j+1])
                    {
                        //System.out.println("setting index to 1 at j = " + j+"   cells now is  "+Arrays.toString(cells));
                        res[j] =1;
                    }
                    else
                    {
                        res[j] =0;
                    }
                }
            }
           
            cells = res;
             //System.out.println("Array now is "+Arrays.toString(cells));
        }
        return cells;
    }
}