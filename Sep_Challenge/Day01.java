import java.util.HashSet;

public class Day01 {
    public int arrayNesting(int[] nums) {
        int len = nums.length;
        int ret=0;
        for(int i=0;i<len;++i)
        {
            if(nums[i] != len)
            {
                int begin = nums[i],temp_count=0;
                while(nums[begin] != len)
                {
                    int temp = begin;
                    begin = nums[begin];
                    temp_count++;
                    nums[temp] = len;
                }
                ret= Math.max(ret,temp_count);
            }
        }
        /*
        HashSet<Integer> set = new HashSet<>();
        int i=0;
        while(true)
        {
            //int val = nums[i];
            if(set.contains(nums[i]))
            {
                return set.size();
            }
            else
            {
                set.add(nums[i]);
                i=nums[i];
                //System.out.println("val is "+nums[i]+"   i is  "+i);
            }
        }
         */
        return ret;
    }
    public static void main(String[] args) {
        int[] input ={0,2,1};

        int x= new Day01().arrayNesting(input);
        System.out.println("value is x "+x);
    }
}