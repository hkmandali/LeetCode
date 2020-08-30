https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3441/
class Solution {
    int findmaxIndex(int[] a,int len)
    {
        int max_index=0;
        for(int i=0;i<len;++i)
        {
            if(a[i] > a[max_index])
                max_index = i;
        }
        return max_index;
    }
    void flip(int[] a, int index)
    {
       // System.out.println("given array is "+Arrays.toString(a) +"   index is  "+index);
        int start=0;
        int end = index;
        /*
        while(start < end)
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
        */
        for(int i=0;i <= (index/2);++i)
        {

            int temp = a[i];
            a[i] = a[end];
            //System.out.println("i is  "+i+"   temp is "+ temp+"  index/2  "+ index/2);
            a[end] = temp;
            end--;
        }
        return;
    }
    public List<Integer> pancakeSort(int[] A) {
        if(null == A || 0 == A.length)
            return null;
        List<Integer> ret = new ArrayList();
        int n = A.length;
        while(n > 1)
        {
            int max_index = findmaxIndex(A,n);
            //System.out.println("max index is "+max_index);
            if(max_index != (n-1)) // if max is the last index , we need not modify that
            {
                // once we get hte max index , we need to bring it beginning by calling flip and then take it to end by calling flip again
                flip(A,max_index); // once this comes to beginning ,we need to take it to end
                ret.add(max_index+1);
              //  System.out.println("calling second flip");
                flip(A,n-1);
                ret.add(n);
            }
            n--;
            //System.out.println("Array now is "+Arrays.toString(A));
        }

        return ret;
    }
}