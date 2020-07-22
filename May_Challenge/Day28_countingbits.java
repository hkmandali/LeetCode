class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num+1];
        ret[0] =0;
        int preveven = 0;// this stores the number of set bits in prev number
        for(int i=1;i<=num;++i)
        {
            if(i%2 == 1)
            {
                ret[i] = ret[i-1]   +1;
            }
            else // last digit is zero , that means 
            {
                ret[i] = ret[i/2] ; // this means the number of set bits is even is num of set bits in num of setbits in num/2 which is even because the bits just shifted to the left 
            }
        }
        
        return ret;
    }
}