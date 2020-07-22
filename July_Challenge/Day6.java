class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int n=len-1;
        int found =0; // set to zero when other digit found
        int carry=1;
        while(n >= 0 && found == 0)
        {
            int curr = digits[n] +carry;
            if(curr > 9)
            {
                carry =1;
                digits[n] =0;
                n--;
            }
            else
            {
                digits[n] = curr;
                found =1;                
            }
        }
        if(-1 == n)
        {
            digits = new int[len+1];
            digits[0] =1;
        }
        return digits;
    }
}