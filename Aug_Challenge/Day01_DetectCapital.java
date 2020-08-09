class Solution {
    public boolean detectCapitalUse(String word) {
        if(null == word || 0 == word.length())
            return true;
        boolean cap = false;
        int len = word.length();
        if(1 == len)
            return true;
        boolean firstcap = word.charAt(0) >=65 && word.charAt(0) <= 90 ? true : false;
        boolean secondcap = word.charAt(1) >=65 && word.charAt(1) <= 90 ? true : false;
        if(firstcap) // first letter is capital
        {
            for(int i=2;i<len;++i)
            {
                if(secondcap != (word.charAt(i) >=65 && word.charAt(i) <= 90 ? true : false))
                    return false;
            }
        }
        else
        {
            for(int i=1;i<len;++i)
            {
                    if(word.charAt(i) <= 90)
                        return false;
            }
        }
        return true;
    }
}