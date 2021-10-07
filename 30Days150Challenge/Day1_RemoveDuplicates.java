import java.util.Arrays;

public class Day1_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(1 >= len)
            return len;
        int replace=0,start=1;
        while(start< len)
        {
            while(start<len && nums[start]==nums[start-1])
            {
                start++;
            }
            //System.out.println("replace outside is "+replace+"  start is "+start);
            if(start == len)
            {
                //System.out.println("replace is "+replace+"  start is "+start);
                nums[replace] = nums[start-1];
                break;
            }
            nums[replace] = nums[start-1];
            start++;
            replace++;
        }
        nums[replace] = nums[len-1];
        System.out.println(Arrays.toString(nums));
        return replace+1;
    }

    public static void main(String[] args) {
        System.out.println("the index is  "+new Day1_RemoveDuplicates().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
