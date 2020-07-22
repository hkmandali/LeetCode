class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        StringBuilder a1 = new StringBuilder(a);
        StringBuilder b1 = new StringBuilder(b);
        int len1 = a.length();
        int len2 = b.length();
        if(len1 > len2)
        {
            for(int i=len1-len2;i>0;--i)
            {
                b1.insert(0,'0');
            }
        }
        else
        {
            for(int i=len2-len1;i>0;--i)
            {
                a1.insert(0,'0');
            }
        }
        int carry =0;
        int max = Math.max(len1,len2);
        for(int i=max-1;i>=0;--i)
        {
            int first = a1.charAt(i) -'0';
            int second = b1.charAt(i)-'0';
            res.insert(0,(first+second+carry)%2);
            carry = (first+second+carry)/2;
        }
        if(carry > 0)
        {
            res.insert(0,(carry)%2);
        }
        return res.toString();
    }
}