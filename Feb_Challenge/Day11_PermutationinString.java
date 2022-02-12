public class Day11_PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        int[] lookup = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        for(int i=0;i<len1;++i)
        {
            lookup[s1.charAt(i)-'a']++;
        }
        int[] lookup2 = new int[26];
        int start=0;
        for(int i=start;i<len2;i++)
        {
            // this element is not present in the array, so increment the start
            if(lookup[s2.charAt(i)-'a'] == 0)
            {
                start = i+1;
                for(int j=0;j<26;++j)
                {
                    lookup2[j] = 0;
                }
            }
            else
            {
                lookup2[s2.charAt(i)-'a']++;
                if(i-start > len1-1) {
                    System.out.println("decreenting at index "+i+"  for start "+start);
                    lookup2[s2.charAt(start)-'a']--;
                    start++;
                }
                if(i-start == len1-1)
                {
                    System.out.println("i is "+i+"  char is "+s2.charAt(i));

                    boolean allmatched = true;
                    for(int j=0;j<26 && allmatched;++j)
                    {
                        if(lookup[j] != lookup2[j])
                        {
                            allmatched = false;
                        }
                    }
                    if(allmatched)
                        return true;
                }
                else
                {
                    System.out.println("incrementing at index "+i+" for "+s2.charAt(i));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("the value is "+new Day11_PermutationinString().checkInclusion("adc","dcda"));
    }
}
