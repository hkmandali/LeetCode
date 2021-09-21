public class Day21_MaxConsecutive1s {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int ret =0;
        int start=0;
        for(int i=0;i<len;++i)
        {
            if(nums[i] != 0)
            {
                ret = Math.max(ret,i-start+1);
            }
            else
            {
                start =i+1;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("the max numbre of 1s are "+ new Day21_MaxConsecutive1s().findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
