class Solution {
    public int addDigits(int num) {
        int sum =0;
        /*
        while(num > 0 || sum > 9)
        {
            if(num == 0)
            {
                num = sum;
                sum = 0;
            }
            sum += num%10;
            num= num/10;
        }
        return sum;
        */
        // method 2
        if(num == 0)
            return 0;
        if(num % 9 == 0)
            return 9;
        return num%9;
    }
}