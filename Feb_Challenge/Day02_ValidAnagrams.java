import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02_ValidAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(null != s && null != p && p.length() <= s.length())
        {

            if(s.equals(p))
            {
                res.add(0);
            }
            else
            {
                int[] countarr = new int[26];
                int[] currcount = new int[26];
                int left=0,right=0;
                for(char c:p.toCharArray())
                {
                    countarr[c-'a']++;
                }
                while(right < s.length())
                {
                    currcount[s.charAt(right)-'a']++;
                    if((right - left) >= p.length())
                    {
                        currcount[s.charAt(left)-'a']--;
                        left++;
                    }
                    if(Arrays.equals(countarr,currcount))
                    {
                        res.add(left);
                    }
                    right++;
                }
            }
        }
        return res;
    }
}
