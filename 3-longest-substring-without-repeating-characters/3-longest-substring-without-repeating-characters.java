class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(null == s || s.length() ==0)
            return 0;
        int res=1;
        int start=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int len = s.length();
        map.put(s.charAt(0),0);
        for(int i=1;i<len;++i)
        {
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                if(map.get(curr) >= start){
                    start = map.get(curr)+1;
                }
            }
            
            res = Math.max(res,i-start+1);
            //System.out.println("max is "+res + "  at start = "+start+"  i = "+i);
            map.put(curr,i);
        }
        return res;
    }
}