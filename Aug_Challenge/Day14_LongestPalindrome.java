https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/
class Solution {
    public int longestPalindrome(String s) {
        if(null == s || 0 == s.length())
            return 0;
        int[] freq = new int[53]; // 1 - 26 A- Z , 27-52 a-z
        int max_index =0;
        int count =0;
        
        for(int i=0;i<s.length();++i)
        {
            char curr = s.charAt(i);
            int index=0;
            if((int)curr >= 97)
            {
                index = curr-'a'+27;                
            }
            else
            {                
                index = curr-'A'+1;
            }    
            freq[index]++;
            if(freq[index] % 2 == 0)
            {
                count += freq[index];
                freq[index] =0;
            }
        }
        
        for(int i=1;i<53;++i)
        {
            if(freq[i] % 2 != 0 )
            {
                count+= freq[i];
                break;
            }
            
        }
        
        return count++;
    }
}