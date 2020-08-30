https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3437/
class Solution {
    private static final String first = "Fizz";
    private static final String second = "Buzz";
    private static final String third = "FizzBuzz";
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList();
        for(int i=1;i<=n;++i)
        {
            if(i%15 == 0)
            {
                ret.add(third);
            }
            else if(i % 3 == 0)
            {
                ret.add(first);
            }
            else if(i%5  == 0)
            {
                ret.add(second);
            }
            else
                ret.add(Integer.toString(i));
        }
        return ret;
    }
}