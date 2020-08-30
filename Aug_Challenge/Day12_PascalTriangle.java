https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3421/
class Solution {
    int comb(int a,int b)
    {
        if(1 == b)
            return a;
        else {           
            int ret =a;
            for(int i=1;i<b;++i)
            {
                if((a-i) % (i+1) == 0)
                {
                    ret = ret * ((a-i) / (i+1));
                }
                else
                {
                    ret = (ret /(i+1)) * (a-i);
                }
                
            }
            return ret;
        }
        
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList();
        ret.add(1);
        long prev=1;
        for(int i=1;i<=rowIndex;++i)
        {     
            
            if(i>rowIndex/2)
            {
                ret.add(ret.get(rowIndex-i));
            }
            else // the first half
            {
                long curr = (prev * (rowIndex-i+1))/i;                
                   
                ret.add((int)curr);
                prev = curr;
                //ret.add(comb(rowIndex,i));
            }
        }
        
        return ret;
    }
}