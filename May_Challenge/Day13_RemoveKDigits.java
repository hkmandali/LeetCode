class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length(); // length of the string
        if(k == len)
        {
            return "0";
        }
        // given that len >= k , so in the string among the first k+1 characters atleast one character would be present in the final string to be returned
        StringBuffer ret = new StringBuffer(num);
        int replaced =0;
       while(replaced < k)
            {
                int i=1;
                while(i<ret.length()  && ret.charAt(i-1) <= ret.charAt(i))
                {
                    i++; // proceed till the previous element is <= next element
                }
                // once we reach that element remove the element
                //System.out.println("i is "+i);
                ret.deleteCharAt(i-1);
                replaced++;
            }


            while(ret.charAt(0) == '0')
            {
                if(ret.length() ==1)
                    return "0";
                ret.deleteCharAt(0);
            }
            return ret.toString();
    }
}