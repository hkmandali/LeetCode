import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day06_FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        System.out.println("the array is "+ Arrays.toString(nums));
        List<Integer> res = new ArrayList();
        if(1 == nums.length)
        {
            return res;
        }
        int len = nums.length;
        for(int i=0;i<len;++i)
        {
            int curr = nums[i];
            System.out.println("the current element is "+curr);
            if(nums[Math.abs(curr)-1] < 0)
            {
                res.add(Math.abs(nums[i]));
            }
            else
                nums[Math.abs(curr)-1] = nums[Math.abs(curr)-1]*(-1);
            System.out.println("array now is "+Arrays.toString(nums));
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("the duplicates are "+Arrays.toString(new Day06_FindAllDuplicates().findDuplicates(new int[]{4,3,2,7,8,2,3,1}).stream().mapToInt(i->i).toArray()));
    }
}
