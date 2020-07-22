class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<String> unique = new HashSet<String>(); // this considers all the unique combinations
        for(int i=0;i<n;++i)
        {
            int left = i+1;
            int right = n-1;
            while(left < right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0)
                {
                    String comb = nums[i]+":"+nums[left]+":"+nums[right];
                    if(!unique.contains(comb))
                    {
                        unique.add(comb);
                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right]));
                    res.add(temp);
                        
                    }
                    left++;
                    right--; // as we need to have unique we increment left and decrement right 
                }
                else if(sum < 0)
                {
                    left++;
                }
                else 
                    right --;
            }
        }
        return res;
    }
}