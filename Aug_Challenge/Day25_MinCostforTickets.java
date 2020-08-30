https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3436/
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(null == days || null == costs || 0 == days.length || 0 == costs.length)
            return 0;
        int len = days.length;
        int[]  dp = new int[days[len-1]+1]; // we need to construct a dp array of all the days , so that we can find the min cost at any day
        HashSet<Integer> traveldays = new HashSet();
        for(int i:days)
        {
            traveldays.add(i);
        }
        for(int i=1;i<dp.length;++i)
        {
            int oneday = costs[0];
            int weekly = costs[1];
            int monthly = costs[2];
            if(!traveldays.contains(i))
            {
                dp[i] = dp[i-1]; // since this day isnt present minimum would be the min till previous day
            }
            else // if this is the travel day , then we need to consider 3 cases - this is among single day , weekly , monthly
            {
                if(i > 7)
                {
                    weekly = dp[i-7] + weekly;
                }
                if(i > 30)
                {
                    monthly = dp[i-30] + monthly;
                }
                oneday = dp[i-1] + oneday;
                dp[i] = Math.min(oneday,Math.min(weekly,monthly));
            }
            
            
            
        }
        
        return dp[dp.length-1];
    }
}