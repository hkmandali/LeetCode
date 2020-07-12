class Solution {
    public void findSubsets(List<List<Integer>> results,int[] nums,int startindex,List<Integer> temp )
    {
        results.add(new ArrayList<>(temp));
        
        for(int i=startindex;i<nums.length;++i)
        {
            temp.add(nums[i]);
            findSubsets(results,nums,i+1,temp); 
            temp.remove(temp.size() -1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(null ==  nums || 0 == nums.length)
            return res;
        findSubsets(res,nums,0,new ArrayList<>()); // results , input array , start index , temp array to store
        return res;
    }
}