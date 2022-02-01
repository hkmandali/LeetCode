public class Day03_RemoveDupfromSorted {
    public int removeDuplicates(int[] nums) {
        if(null == nums || 1 >= nums.length)
            return 1;
        int len = nums.length;
        int k=1;
        for(int i=1;i<len;++i)
        {
            while(i < len && nums[i] ==  nums[i-1])
                i++;
            if(i < len) {
                nums[k] = nums[i];
                k++;
            }
            else
                return k;
        }
        return k;
    }
    public static void main(String[] args) {
        System.out.println("output is "+new Day03_RemoveDupfromSorted().removeDuplicates(new int[]{1,1,2}));//{0,0,1,1,1,2,2,3,3,4}));
    }
}
