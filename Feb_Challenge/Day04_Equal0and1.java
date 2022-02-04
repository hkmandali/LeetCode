import java.util.HashMap;

public class Day04_Equal0and1 {
    public int findMaxLength(int[] nums) {
        if(null == nums || 0 ==nums.length)
            return 0;
        int len = nums.length;
        int res=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<len;++i)
        {
            sum += nums[i] == 0?-1:1;
            if(map.containsKey(sum))
            {
                res = Math.max(res,i-map.get(sum));
            }
            else
                map.put(sum,i);
        }
        return res;
    }
}
