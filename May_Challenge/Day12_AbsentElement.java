class Solution {
    public int singleNonDuplicate(int[] nums) {
        int absent = 0;
        for(int i=0;i<nums.length;++i)
        {
            absent = absent ^ nums[i];
        }
        return absent;
    }
}