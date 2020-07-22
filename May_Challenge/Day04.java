class Solution {
    public int findComplement(int num) {
        int numdigits = (int)(Math.floor(Math.log(num)/Math.log(2))) +1;
        int allones = (1 << numdigits) -1 ;
        int res = allones ^ num;
        return res;
    }
}