class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(null == people || 0 ==  people.length || 0 == people[0].length)
            return new int[][]{};
        int row = people.length;
        int col = people[0].length;
        List<int[]> ret = new ArrayList<>();
        
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] l1, int[] l2)
            {
                if(l1[0] > l2[0])
                {
                    return -1;
                }
                else if(l1[0] == l2[0])
                {
                    if(l1[1] > l2[1])
                    {
                        return 1;
                    }
                    return -1;
                }
                return 1;
            }
        });
        
        for(int[] i:people)
        {
            ret.add(i[1],i);
        }
        
        
        return ret.toArray(new int[row][col]);
    }
}