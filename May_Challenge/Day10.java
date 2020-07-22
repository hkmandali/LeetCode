class Solution {
    public int findJudge(int N, int[][] trust) {
        HashSet<Integer> trustset = new HashSet<>(); // this set contains the different trust mem
        int[] trustarr = new int[N+1];
        int len = trust.length;
        for(int i=0;i<len;++i)
        {
            trustset.add(trust[i][0]);
            trustarr[trust[i][1]]++;
        }
        for(int i=1;i< N+1;++i)
        {
            if(trustarr[i] == N-1) // he is trusted by eveyone else
            {
                if(!trustset.contains(i))
                {
                    return i;
                }
            }
        }
        return -1;
    }
}