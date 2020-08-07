class Solution {
    void topological(HashMap<String,PriorityQueue<String>> map,String s,LinkedList<String> result)
    {
        PriorityQueue<String> pq = map.get(s);
        
        while(pq != null && !pq.isEmpty())
        {
            String curr = pq.poll();
            topological(map,curr,result);
        }
        result.addFirst(s);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ret = new LinkedList();
        HashMap<String,PriorityQueue<String>> map = new HashMap();
        // construct the graph
        for(List<String> entry : tickets)
        {
            if(map.get(entry.get(0)) == null)
            {
                map.put(entry.get(0),new PriorityQueue());
            }
            PriorityQueue<String> pq = map.get(entry.get(0));
            pq.add(entry.get(1));
            map.put(entry.get(0),pq);
        }
        topological(map,"JFK",ret);
        return ret;
    }
}