class Solution {
    public int firstUniqChar(String s) {
        if(null == s || "" == s)
            return -1;
        HashMap<Character,Integer> countmap = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len;++i)
        {
            countmap.put(s.charAt(i),countmap.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<len;++i)
        {
            if(1 == countmap.get(s.charAt(i)))
                return i;
        }
        return -1;
    }
}