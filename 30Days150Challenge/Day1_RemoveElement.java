import java.util.Arrays;

public class Day1_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int start=0;
        for(int i=0;i<len;++i)
        {
            if(nums[i] != val)
            {
                nums[start] = nums[i];
            }
        }
        return start+1;
    }
    public static void main(String[] args) {
        System.out.println("after removing element "+new Day1_RemoveElement().removeElement(new int[]{4,5},4));
    }
}
