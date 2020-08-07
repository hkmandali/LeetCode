class Solution {
    public int[] singleNumber(int[] nums) {
        int len = nums.length;
        int x=0,y=0;
        int xor=0,rightmostset=0;
        for(int i=0;i<len;++i)
        {
            xor = xor ^ nums[i];
        }// now xor will have x ^ y , the set bits of xor will be the set bits of x and y
        while((xor & 1) != 1 )
        {
            xor = xor>>1;
            rightmostset++;
        }
        for(int i=0;i<len;++i)
        {
            if((nums[i]>>rightmostset & 1) ==1)
                x ^= nums[i];
            else
                y ^= nums[i];
        }
        int[] ret = new int[2];
        ret[0] =x;
        ret[1] =y;
        return ret;
    }
}