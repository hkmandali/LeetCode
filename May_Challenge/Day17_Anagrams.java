class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /// we can solve this by storing the occurences of characters in a hashmap
        List<Integer> res = new ArrayList<>();
        if(null == s || 0 == s.length())
            return res;
        HashMap<Character,Integer> pmap = new HashMap<>();
        HashMap<Character,Integer> smap = new HashMap<>();
        int len = p.length();
        int n = s.length();
        if(len >= n)
        {
            if(s.equals(p))
            {
                res.add(0);
            }
            return res;

        }
        for(int i=0;i<len;++i)
        {
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);
        }
        
        // now that we have stored the occurences of p(to be matched) string       
        
        for(int i=0;i<len;++i)
        {
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1); // for storing parent maps data
        }
        
        int start =0;
        int end= len-1; //inclusive
        int laststart = n-len; // inclusive
        int lastend = n;
        
        while(end <= lastend)
        {       
            boolean matched = true;
            for(int i=0;i<len;++i)
            {
                if(!pmap.get(p.charAt(i)).equals(smap.get(p.charAt(i))))
                {
                    matched = false;
                    break;
                }
            }
            if(matched)
                res.add(start);
            smap.replace(s.charAt(start),smap.get(s.charAt(start))-1); // decrementing the count by 1 
            if(end < (n-1))
                smap.put(s.charAt(end+1),smap.getOrDefault(s.charAt(end+1),0)+1);
            else
                break;
            start++;
            end++;
        }
        return res;
    }
}