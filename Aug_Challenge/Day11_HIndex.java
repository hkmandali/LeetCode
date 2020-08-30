https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3420/
class Solution {
    public int hIndex(int[] citations) {
        if(null == citations || 0 == citations.length)
            return 0;
        Arrays.sort(citations);
        int n= citations.length;
        int high = citations.length-1;
        int low=0;
        while(low <= high)
        {
            int mid = low +(high-low)/2;
            if(citations[mid] < (n-mid) )
            {
                low = mid+1;
            }
            else 
                high = mid-1;
        }
        return citations.length-low;
    }
}