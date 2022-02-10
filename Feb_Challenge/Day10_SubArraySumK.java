import java.util.HashMap;

public class Day10_SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        int ret=0;
        // map to store sum vs num of times the sum occurs
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        int sum=0;
        map.put(0,1);
        for(int i=0;i<len;++i)
        {
            sum += nums[i];
            if(map.containsKey(sum-k))
                ret += map.get(sum-k);
            map.put(sum,1+map.getOrDefault(sum,0));
        }
        return ret;
    }
}
