class Solution {
    public int numJewelsInStones(String J, String S) {
        int count =0;
        HashSet<Character> jewel = new HashSet<>();
        int len1 = J.length();
        for(int i=0;i<len1;++i)
        {
            jewel.add(J.charAt(i));
        }
        len1 = S.length();
        for(int i=0;i<len1;++i)
        {
            if(jewel.contains(S.charAt(i)))
            {
                count++;
            }
        }
        return count;
    }
}