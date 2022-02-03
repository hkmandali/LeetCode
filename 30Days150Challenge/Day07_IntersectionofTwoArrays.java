import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day07_IntersectionofTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ret = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums1)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int j:nums2)
        {
            if(map.containsKey(j))
            {
                ret.add(j);
                map.put(j,map.get(j)-1);
                if(map.get(j) == 0)
                    map.remove(j);
            }
        }
        int[] res = new int[ret.size()];
        for(int i=0;i<ret.size();++i)
        {
            res[i] = ret.get(i);
        }
        return res;
    }
}
