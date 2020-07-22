class Solution {
    public String reverseWords(String s) {
        if(null == s)
            return null;
        if(" " == s)
            return "";
        StringBuffer ret = new StringBuffer();
        String[] split = s.split("\\s+");
        int len = split.length;
        if(len >=1)
        {
            ret.append(split[len-1]);
            for(int i=len-2;i>=0;--i)
            {
                ret.append(" ");
                ret.append(split[i]);
            }
            return ret.toString().trim();
        }
        return "";
    }
}