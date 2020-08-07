class Solution {
    
    // we need to 
    public int twoCitySchedCost(int[][] costs) {
        if(null == costs || 0 == costs.length)
            return 0;
        Arrays.sort(costs,new Comparator<int[]>(){
            public int compare(int[] l1,int[] l2)
            {
                if(l1[1] -l1[0] > (l2[1] -l2[0]))     
                    return -1;
                else if(l1[1] -l1[0] < (l2[1] -l2[0]))     
                    return 1;
                return 0;
            }
        });
        int len = costs.length;
        int ret =0;
        for(int i=0;i<len;++i)
        {
            if(i < len/2)
            {
                ret += costs[i][0];
            }
            else
                ret += costs[i][1];
            
        }
        return ret;
        
        
    }
}