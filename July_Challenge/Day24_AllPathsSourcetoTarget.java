class Solution {
    void dfs(int[][] graph,List<List<Integer>> ret,int vertex,List<Integer> path)
    {
        List<Integer> inter = new ArrayList<>(path);
        inter.add(vertex);
        if(graph.length-1 == vertex)
        {
            ret.add(inter);
        }
        for(int i=0;i<graph[vertex].length;++i)
        {
            dfs(graph,ret,graph[vertex][i],inter); 
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(null == graph || 0 == graph.length || 0 == graph[0].length)
            return null;
        List<List<Integer>> ret = new ArrayList<>();
        dfs(graph,ret,0,new ArrayList<>());
        return ret;
    }
}