class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0)
            return false;
        return Math.ceil(Math.log(num)/Math.log(4)) == Math.floor(Math.log(num)/Math.log(4));
    }
}