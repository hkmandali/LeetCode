public class Day11_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int replace=0;
        for(int i=0;i<len;++i)
        {
            if(nums[i] != 0)
            {
                nums[replace] = nums[i];
                replace++;
            }
        }
        for(int i=replace;i<len;++i)
            nums[i] = 0;
    }
}
