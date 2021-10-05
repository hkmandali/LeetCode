public class Day05_Stairs {
    public int climbStairs(int n) {
        if(n < 4)
            return n;
        int[] arr = new int[n+1];
        for(int i=1;i<n+1;++i)
        {
            if(i<4)
            {
                arr[i] = i;
            }
            else
                arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
