import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqmap = new HashMap<>();
        int len = nums.length;
        int[] ret = new int[k];
        for(int i=0;i<len;++i)
        {
            freqmap.put(nums[i],freqmap.getOrDefault(nums[i],0)+1);
        }
        // now we have a hashmap of numbers and their frequencies 
        // we can push them to a max heap with their frequencies as the comparator
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Integer,Integer>>(){
                public int compare(Map.Entry<Integer,Integer> n1,Map.Entry<Integer,Integer> n2)
                {
                    if(n1.getValue() == n2.getValue())
                    {
                        return n2.getKey() -n1.getKey();
                    }
                    return n2.getValue() - n1.getValue();
                }
            }
        );
        for(Map.Entry<Integer,Integer> mp : freqmap.entrySet())
        {
            pq.add(mp);
        }
        for(int i=0;i<k;++i)
        {
            ret[i] = pq.poll().getKey();
        }
        return ret;
    }
}