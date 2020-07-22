class Solution {
    public boolean topological(HashMap<Integer,List<Integer>> map,int[] visited,int startvertex)
    {
        if(1 == visited[startvertex])
            return true;
        
        if(-1 == visited[startvertex])
            return false;
        
        visited[startvertex]  = -1;
        
        if(map.containsKey(startvertex))
        {
            List<Integer> vertexlist= map.get(startvertex);
            for(int i:vertexlist)
            {
                if(!topological(map,visited,i))
                    return false;
            }   
        }
        
        visited[startvertex] =1;
        return true;
        
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if(0 == len)
        {
            return true;
        }
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<len;++i)
        {
            if(map.containsKey(prerequisites[i][0]))
            {
                List<Integer> obj = map.get(prerequisites[i][0]);
                obj.add(prerequisites[i][1]);
                map.put(prerequisites[i][0],obj);
                    
            }
            else
            {
                List<Integer> obj = new ArrayList<>();
                obj.add(prerequisites[i][1]);
                map.put(prerequisites[i][0],obj);
            }
        }
        // adjacency list has been constructed
        int[] visited = new int[numCourses];
        for(int i=0;i<len;++i)
        {
            if(!topological(map,visited,prerequisites[i][0]))
            {
                return false;
            }
        }
        
        return true;
    }
}