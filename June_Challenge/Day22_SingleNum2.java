class Solution {
    public int singleNumber(int[] nums) {
        /*
        int len = nums.length;
        int[] bitarr = new int[32]; // since 32 bit integers 
        // we can know which bits are set for each number by iterating through the input arr and the final ans would be the bits set in this bitarr
        int res = 0;
        for(int i=0;i<32;++i)
        {
            for(int n:nums)
            {
                bitarr[i] = bitarr[i] +((n >> i) &1);
                bitarr[i] %= 3;
            }
        }
        for(int i=0;i<32;++i)
        {
            res = res | (bitarr[i] <<i);
        }
        return res;
        */
        // method 2 by looking from net 
        int ones =0;
        int twos =0; // we are calculating the set bits in both the nums , ones denote the elements which occur once , twos denote elements which occur twice
        for(int n:nums)
        {
            ones = (ones ^ n ) & (~twos);
            twos = (twos ^ n ) & (~ones);
        }
        return ones;
    }
}