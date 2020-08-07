class Solution {
    int min = Integer.MAX_VALUE;
    int findMin(int src,int dest,int K,HashMap<Integer,List<Pair<Integer,Integer>>> map,boolean[] visited,int dist, int disttravelled)
    {
        if(src == dest)
        {
            return disttravelled;
        }
        if(!map.containsKey(src))
            return min;
        if(dist > K)
            return Integer.MAX_VALUE;
        
        if(null != map.get(src))
        {
            List<Pair<Integer,Integer>> curr = map.get(src);
            //System.out.println("source is "+src);
            int size = curr.size();
            if(!visited[src])
            {
                
                visited[src] = true;
                for(int i=0;i<size;++i)
                {
                    //System.out.println("vretex is "+curr.get(i).getKey()+"   value is  "+curr.get(i).getValue());
                    if(disttravelled+ curr.get(i).getValue() < min) // if we think it is minimum , then only proceed
                    {
                     min = Math.min(min , findMin(curr.get(i).getKey(),dest,K,map,visited,dist+1,disttravelled+
                                                curr.get(i).getValue()));
                    }
                }
                visited[src] = false;
            }
            
        }
        
        
        
        
        return min;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(flights == null || 0 == flights.length)
            return -1;
        HashMap<Integer,List<Pair<Integer,Integer>>> map = new HashMap();
        for(int i=0;i<flights.length;++i)
        {
            if(map.containsKey(flights[i][0]))
            {
                List<Pair<Integer,Integer>> arrList = map.get(flights[i][0]);
                int first = flights[i][1];
                int second = flights[i][2];
                arrList.add(new Pair(first,second));
            }
            else
            {
                List<Pair<Integer,Integer>> arrList = new ArrayList<>();
                int first = flights[i][1];
                int second = flights[i][2];
                arrList.add(new Pair(first,second));
                map.put(flights[i][0],arrList);
            }
        }
        boolean[] visited = new boolean[n];
        min = findMin(src,dst,K,map,visited,0,0); // 
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}