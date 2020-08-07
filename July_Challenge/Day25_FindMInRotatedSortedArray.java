class Solution {
    // as it is rotated , only one half is not properly sorted
    int finMinutil(int[] a,int low,int high)
    {
        while(low < high)
        {
            int mid = low +(high-low)/2;
            if(a[low] > a[mid])
            {
                high = mid;
            }
            else if(a[mid] > a[high])
            {
                low = mid+1;
            }
            else
                high--;
        }
        return a[high];
    }
    int finMinRecur(int[] a,int low,int high)
    {
        if(low == high)
            return a[low];
        int mid = low +(high-low)/2;
        if(a[low] > a[mid])
        {
            return finMinRecur(a,low,mid);
        }
        else if(a[mid] > a[high])
        {
            return finMinRecur(a,mid+1,high);
        }
        return finMinRecur(a,low,--high);
    }
    public int findMin(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        return finMinRecur(nums,0,nums.length-1);
    }
}