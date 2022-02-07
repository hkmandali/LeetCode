public class Day07_FindtheDifference {
    public char findTheDifference(String s, String t) {
        if(null == s || 0 == s.length())
            return t.charAt(0);
        int xor=0;
        int len1 = s.length(),len2 = t.length();
        for(int i=0;i<len1;++i)
            xor ^= s.charAt(i);
        for(int i=0;i<len2;++i)
            xor ^= t.charAt(i);
        return (char)xor;
    }
}
