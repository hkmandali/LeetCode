class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomArray = new int[26]; // no of lower case letters
        int len = magazine.length(); // we first put the maggazine characters into array
        for(int i=0;i<len;++i)
        {
            ransomArray[magazine.charAt(i)-'a']++;
        }
        len= ransomNote.length();
        for(int i=0;i<len;++i)
        {
            int num = ransomNote.charAt(i)-'a';
            if(ransomArray[num] == 0)
            {
                return false;
            }        
            ransomArray[num]--;
        }
        return true;
    }
}