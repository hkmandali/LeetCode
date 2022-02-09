import java.util.*;

public class Day13_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
    if(null == nums || 0 == nums.length)
    {
        return new ArrayList<>();
    }
    List<List<Integer>> ret ;
    Set<List<Integer>> set = new HashSet<>();
    int len = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<len-2;++i)
    {
        int j=i+1;
        int k=len-1;
        while(j<k)
        {
            int sum = nums[i]+nums[j]+nums[k];
            if(sum == 0)
            {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(nums[i]);
                a.add(nums[j]);
                a.add(nums[k]);
                set.add(a);

                j++;

            }
            else if(sum < 0)
            {
                j++;
            }
            else
                k--;
        }
    }
    ret = new ArrayList<>(set);
        return ret;
}
}
