import java.util.HashMap;

public class Day09_KDiffPairs {
    public int findPairs(int[] nums, int k) {
        int ret =0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet())
        {
            if((k==0 && map.get(i) >1) || (k>0 && map.containsKey(i+k)))
                ret++;
        }
        return ret;
    }
}
