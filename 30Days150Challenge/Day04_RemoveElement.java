public class Day04_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(null == nums || 0 == nums.length)
            return 0;
        int len = nums.length;
        int replace =0;
        for(int i=0;i<len;++i)
        {
            if(nums[i] != val)
            {
                nums[replace++] = nums[i];
            }
        }
        return replace;
    }
    public static void main(String[] args) {
        System.out.println("after removing element "+ new Day04_RemoveElement().removeElement(new int[]{},0));//{0,1,2,2,3,0,4,2},2));
    }
}
