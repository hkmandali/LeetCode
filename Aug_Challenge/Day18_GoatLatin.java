https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3429/

class Solution {
    boolean isVowel(char x)
    {
        if(x == 'a' || x == 'e' || x =='i' || x =='o' || x == 'u' || x == 'A' || x == 'E' || x =='I' || x =='O' || x == 'U')
            return true;
        return false;
    }
    String allA(int index)
    {
        StringBuilder ret = new StringBuilder();
        for(int i=0;i<index;++i)
        {
            ret.append('a');
        }
        return ret.toString();
    }
    public String toGoatLatin(String S) {
        if(null == S || 0 == S.length())
            return S;
        StringBuilder sb = new StringBuilder();
        String[] split = S.split("\\s+");
        for(int i=0;i<split.length;++i)
        {
            
            StringBuilder curr = new StringBuilder(split[i]);
            if(!isVowel(curr.charAt(0)))
            {
                curr.append(curr.charAt(0));
                curr.deleteCharAt(0);
            }
            curr.append("ma");
            curr.append(allA(i+1));
            sb.append(curr);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}