public class Day06_RemoveDupfromSortedii {
    public int removeDuplicates(int[] nums) {
        int res =0;
        int len = nums.length;
        int same =1,replace =1;
        for(int i=1;i<len;++i)
        {
            if(nums[i] == nums[i-1])
            {
                if(same < 2)
                {
                    nums[replace] = nums[i];
                    replace++;
                    same++;
                }
                else
                {
                    while(i< len && nums[i] == nums[i-1])
                    {
                        i++;
                    }
                    if(i < len)
                    {
                        nums[replace] = nums[i];
                        replace++;
                        same =1;
                    }
                }
            }
            else
            {
                same =1;
                nums[replace] = nums[i];
                replace++;
            }
        }

        return replace;
    }
}
