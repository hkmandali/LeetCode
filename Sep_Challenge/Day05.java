import java.util.Arrays;

public class Day05 {
    // took this example from internet
    // since a constraint is given that k >= 1 , we have two cases , k== 1 and k >1
    public String orderlyQueue(String s, int k) {
        if(k > 1)
        {
            char[] strarray = s.toCharArray();
            Arrays.sort(strarray);
            return new String(strarray);
        }
        else // k==1 , we need to consider every case where each character can come in the beginning and compare them
        {
            String res = s;
            for(int i=0;i<s.length();++i)
            {
                String temp = s.substring(i) + s.substring(0,i) ;
                if(temp.compareTo(res) < 0)
                {
                    res = temp;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String ret = new Day05().orderlyQueue("kjhjabha",2);
        System.out.println("shortest string is "+ret);
    }
}
