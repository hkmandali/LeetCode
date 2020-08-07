class Solution {
    public int hIndex(int[] citations) {
        
        int high = citations.length -1;
        int low =0;
        while(low <= high)
        {
            int mid = low +(high-low)/2;
            if(citations[mid] <  citations.length-mid)
                low = mid+1;
            else
                high = mid-1;
        }
        return citations.length-low;
    }
}