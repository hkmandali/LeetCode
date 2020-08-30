https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3419/
class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int ret =0;
        for(int i=0;i<len;++i)
        {
            ret += Math.pow(26,len-i-1)*(s.charAt(i)-'A'+1);
        }
        
        return ret;
    }
}