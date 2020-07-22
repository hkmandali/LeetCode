class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> patmap = new HashMap<>();
        int len = s1.length();
        int len2 = s2.length();
        if(len > len2)
            return false;
        for(int i=0;i<len;++i)
        {
            patmap.put(s1.charAt(i),patmap.getOrDefault(s1.charAt(i),0)+1);
        }
        HashMap<Character,Integer> strmap = new HashMap<>();
        for(int i=0;i<len;++i)
        {
            strmap.put(s2.charAt(i),strmap.getOrDefault(s2.charAt(i),0)+1);
        }
        int start =0;
        int end = len-1;
        while(end < len2)
        {
            boolean found = true;
            for(int i=0;i<len;++i)
            {
                // if atleast one of the character count doesnt match break
                if(!patmap.get(s1.charAt(i)).equals(strmap.get(s1.charAt(i))))
                {
                    found = false;
                    break;
                }
            }
            if(found)
            {
                return true;
            }
            strmap.replace(s2.charAt(start) ,strmap.get(s2.charAt(start))-1);
            if(end <(len2 -1))
               strmap.put(s2.charAt(end+1),strmap.getOrDefault(s2.charAt(end+1),0)+1);
            start++;
            end++;
        }
        
        return false;
    }
}