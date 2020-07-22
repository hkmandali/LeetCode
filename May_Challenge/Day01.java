/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int findmin(int low , int high)
    {
        
        
        while(low < high)
        {
            int mid = low + (high -low)/2;
            if(!isBadVersion(mid))
            {
                low = mid +1;
            }
            else
            {
                high = mid;
            }
            
        }
        return low;
        
    }
    public int firstBadVersion(int n) {
        int low = 1, high =n;
        
        
        return findmin(low,high);
    }
}