import java.util.ArrayList;

public class Day10_PlusOne {
    public int[] plusOne(int[] digits) {
        if(null == digits || 0 == digits.length)
            return null;
        ArrayList<Integer> ret = new ArrayList<>();
        int len = digits.length;
        int carry=1;
        for(int i=len-1;i>=0;--i)
        {
            if(digits[i]+carry > 9)
            {
                ret.add(0,0);
                carry=1;
            }
            else{
                ret.add(0,digits[i]+carry);
                carry =0;
            }
        }
        if(1 == carry)
            ret.add(0,1);
        int[] res = new int[ret.size()];
        for(int i=0;i<ret.size();++i)
        {
            res[i] = ret.get(i);
        }
        return res;
    }
}
