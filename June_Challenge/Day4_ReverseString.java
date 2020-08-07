class Solution {
    public void reverseString(char[] s) {
        if((null == s) || 0 == s.length)
            return;
        int len = s.length;
        for(int i=0;i<len/2;++i)
        {
            char temp = s[len-1-i];
            s[len-1-i] = s[i];
            s[i] = temp;
        }
    }
}