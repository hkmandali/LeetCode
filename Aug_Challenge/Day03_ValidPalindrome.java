class Solution {
    public boolean isPalindrome(String s) {
        if(null == s )
            return true;
        s = s.trim();
        if("" ==s )
            return true;
        int len = s.length();
        int left =0,right = len-1;
        while(left < right)
        {
            while(left < right && !((s.charAt(left) >=65  && s.charAt(left) <=90) || (s.charAt(left) >=97 && s.charAt(left) <=122) || (s.charAt(left) >=48 && s.charAt(left) <=57)))
                left++;
            while(right >0 && !((s.charAt(right) >=65  && s.charAt(right) <=90) || (s.charAt(right) >=97 && s.charAt(right) <=122) || (s.charAt(right) >=48 && s.charAt(right) <=57)))
                right--;
            if(left < right)
            {
                char leftside = s.charAt(left);
                char rightside = s.charAt(right);
                if(Character.toUpperCase(leftside) == Character.toUpperCase(rightside))
                {
                    left++;
                    right--;
                }
                else
                    return false;
            }
        }
        return true;
    }
    
}