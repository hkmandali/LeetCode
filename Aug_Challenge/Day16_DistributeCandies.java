https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3427/
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ret = new int[num_people];
        int curr=1;
        while(candies != 0)
        {
            for(int i=0;i<num_people;++i)
            {
                if(candies <curr)
                {
                    ret[i] += candies;
                    return ret;
                }
                else
                {
                    ret[i] += curr;
                    candies = candies -curr;
                    curr += 1;                    
                }
            }
        }
        
        
        return ret;
    }
}