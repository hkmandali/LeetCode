// this has been done by looking from net
class Solution {
    public boolean isPerfectSquare(int num) {
        // we can directly loop from 1 to i*i < n , it would take sqrt n time complexity , below one is even lower
        // we can find it out by summing the odd numbers as the sum of odd numbers is a perfect square
        
        /*int sum=0;
        for(int i =1;sum < num;i=i+2)
        {
            sum += i;
            if(sum == num)
            {
                return true;
            }
        }
        return false;
        */ //--> TLE for this approach
        int high =num;
        int low = 1;
        while(low <= high)
        {
            double mid = low +(high - low)/2;
            double sqr = mid*mid;
            //System.out.println("sqr is "+sqr+"  mid is "+mid+"  low is "+low+"   high is "+high) ;
            if(sqr == num)
            {
                return true;
            }
            else if(sqr > num)
            {
                high = (int)(mid-1);
            }
            else
                low = (int)(mid+1);
        }
        return false;
    }
}