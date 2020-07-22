class Solution {
    public String frequencySort(String s) {
        if(null == s)
            return s;
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb= new StringBuilder();
        int len = s.length();
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
            new Comparator<>(){
                public int compare(Map.Entry<Character,Integer> k1,Map.Entry<Character,Integer> k2)
                {
                    return k2.getValue() - k1.getValue();
                }
            }
        );
        for(int i=0;i<len;++i)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            pq.add(entry);
        }
        while(!pq.isEmpty())
        {
            Map.Entry<Character,Integer> current = pq.poll();
            char c = current.getKey();
            char[] fill = new char[current.getValue()];
            Arrays.fill(fill,c);
            sb.append(String.valueOf(fill));
            
        }
        return sb.toString();
    }
}