import java.util.Arrays;
import java.util.HashMap;

public class DoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if(null == changed || (changed.length % 2 != 0))
        {
            return new int[]{};
        }
        Arrays.sort(changed);
        HashMap<Integer,Integer> findint = new HashMap<>();
        int len = changed.length;
        for(int i=0;i<len;++i)
        {
            findint.put(changed[i],findint.getOrDefault(changed[i],0)+1);
        }
        int end = len-1;
        int[] ret = new int[len/2];
        int i=0;
        while(end != 0)
        {
            int curr = changed[end];
            if(findint.containsKey(curr))
            {
                if((curr % 2) != 0)
                {
                    System.out.println("returning from here");
                    return new int[]{};
                }
                if(findint.containsKey(curr/2))
                {
                    ret[i++] = curr/2;
                    findint.put(curr,findint.get(curr)-1);
                    findint.put(curr/2,findint.get((curr/2))-1);
                    if(findint.get(curr) ==0)
                    {
                        findint.remove(curr);
                    }
                    if(findint.containsKey(curr/2) && findint.get(curr/2) ==0)
                    {
                        findint.remove(curr/2);
                    }

                }
                else
                {
                    return new int[]{};
                }
            }
            end--;
        }
        if(findint.size() != 0)
        {
            return new int[]{};
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("hte returned array is "+Arrays.toString(new DoubledArray().findOriginalArray(new int[]{0,0,0,0})));
    }
}
