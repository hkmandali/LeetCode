class Solution {
    // this can be solved using a heap
    public int[][] kClosest(int[][] points, int K) {
        if(null == points || 0 == points.length || 0 == points[0].length)
        {
            return new int[][]{};
        }
        int len = points.length;
        // priority queue , return method is either 0 , <0 or >0
        // if >0 a is placed before b , <0 b is placed before a
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>(){
                public int compare(int[] a, int[] b)
                {
                    return b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] *a[1]);
                }
        });
        for(int i=0;i<len;++i)
        {
            pq.add(points[i]);
            if(pq.size() > K)
                pq.poll();
        }
        int size = pq.size();
        int[][] ret = new int[size][2];
        int i=0;
        while(!pq.isEmpty())
        {
            ret[i]= pq.poll();
            i++;
            
        }
        return ret;
    }
}