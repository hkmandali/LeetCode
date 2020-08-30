https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3428/

class Solution {
    List<Integer> ret ;
    public void util(int num,int N,int K)
    {
         if(N == 0)
        {
            ret.add(num);
            return;
        }

        for(int i=0;i<=9;++i)
        {
            int curr = num%10 -i;
            if(curr == K || curr == -K)
            {
                //System.out.println("curr is "+curr +"  k is "+K);
                util(num*10 + i,N-1,K);
            }
        }

        return;
    }
    
    public int[] numsSameConsecDiff(int N, int K) {
       ret = new ArrayList();
        if(1 == N)
            ret.add(0);
        for(int i=1;i<=9;++i)
        {
            util(i,N-1,K);
        }


        int len = ret.size();

        int[] arr = new int[len];

        for(int i=0;i<len;++i)
        {
            arr[i] = ret.get(i);
        }

        return arr;
    }
}