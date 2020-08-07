class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] fact = new int[10];
        fact[0] = 1;
        fact[1] = 1;
        List<Integer> arrlist= new ArrayList();
        for(int i=2;i<10;++i)
        {
            fact[i] = fact[i-1] *(i);
        }
        for(int i=1;i<=n;++i)
        {
            arrlist.add(i);
        }
        while(arrlist.size() > 0)
        {
            int currentindex = (k-1) / fact[--n];
            sb.append(arrlist.remove(currentindex));
            k = k - (currentindex * fact[n]);
        }
        
        return sb.toString();
    }
}