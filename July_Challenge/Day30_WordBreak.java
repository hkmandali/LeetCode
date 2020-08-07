class Solution {
    List<String> wordBreakUtil(String s,HashSet<String> map,int start,int end,HashMap<String,List<String>> cache)
    {
        if(cache.containsKey(s.substring(start)))
            return cache.get(s.substring(start));
        List<String> arrlist = new ArrayList<>();
        if(start >= end){
            arrlist.add("");
            return arrlist;
        }
            
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<end;++i)
        {
            sb.append(s.charAt(i));
            String curr= sb.toString();
            if(map.contains(curr))
            {
                List<String> ref = wordBreakUtil(s,map,i+1,end,cache);
                for(String sf:ref)
                {
                    String space = sf.isEmpty()?"":" ";
                    arrlist.add(curr+space +sf);
                }
            }
            
        }
        cache.put(s.substring(start),arrlist);
        return arrlist;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> map = new HashSet<>();
        for(String st:wordDict)
        {
            map.add(st);
        }
        List<String> res = wordBreakUtil(s,map,0,s.length(),new HashMap<String,List<String>>());        
        return res;
    }
}