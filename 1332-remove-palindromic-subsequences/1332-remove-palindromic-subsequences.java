class Solution {
    public int removePalindromeSub(String s) {
        // since there are only two characters a and b, and we are asked to find out the palindromic subsequences, all the a's are a subsequence and all the b's are a subsequence, so the max number of steps would be 2. if the given input string is itself a palindrome , then the result would be 1
        
        return s.equals(new StringBuilder(s).reverse().toString()) ? 1:2;
    }
}