class Solution {
    public boolean isPowerOfTwo(int n) {
        long i=1;
        while(i<n)
        {
            i = i *2;
        }
        return i==n;
    }
}