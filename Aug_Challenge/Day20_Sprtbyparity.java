https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431/
class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(null == A || 0 == A.length)
            return null;
        int first =0,last =A.length-1;
        while(first < last)
        {
            if(A[first]%2 == 0 || A[last]%2 == 1)
            {
                if(A[first]%2 == 0)
                    first++;
                if(A[last]%2 == 1)
                    last--;
            }
            else // A[first] is odd , A[last] is even
            {
                int temp = A[first];
                A[first] = A[last];
                A[last] = temp;
                first++;
                last--;
            }
        }
        return A;
    }
}