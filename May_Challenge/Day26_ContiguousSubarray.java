class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int max_len =0;
        int sum =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i=0;i<len;++i)
        {
            if(nums[i] == 0)
            {
                nums[i] = -1;
            }
            sum += nums[i];
            //System.out.println("sum is "+sum);
            if(!map.containsKey(sum)) // if the map doesnt contain the key , add it to the map
            {
                map.put(sum,i+1);
            }
            else // if the key is present , diff would be of max diff bw this index and prev sum index , as they would be equal only if sum of all elements in bw are equal to 0
            {
              //  System.out.println("max len from here"+i);
                max_len = Math.max(max_len,i+1-map.get(sum));
            }
            
        }
        return max_len;
    }
}