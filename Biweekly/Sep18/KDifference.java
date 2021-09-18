import java.util.Arrays;

public class KDifference {
    public int countKDifference(int[] nums, int k) {
        int ret =0;
        if(null == nums || 1 == nums.length)
        {
            return ret;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<len-1;++i)
        {
            for(int j=i+1;j<len;++j)
            {
                int diff = nums[j] - nums[i];
                if(diff == k)
                {
                    ret++;
                }

            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("return is "+new KDifference().countKDifference(new int[]{3,1},3));
    }
}
