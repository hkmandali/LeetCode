class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length-1,left=0;
        while(left < right)
        {
            if(numbers[left] + numbers[right] < target)
                left++;
            else if(numbers[left] + numbers[right] > target)
                right--;
            else
                return new int[]{left+1,right+1};
        }
        return new int[]{left+1,right+1};
    }
}