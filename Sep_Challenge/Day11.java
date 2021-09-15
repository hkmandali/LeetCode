import java.util.Stack;

public class Day11 {
    public int calculate(String s) {
        int ret =0;
        if(null == s || "" == s)
            return 0;
        int temp=0;
        int sign =1;
        Stack<Integer> st = new Stack<>();
        st.push(1);
        int len = s.length();
        for(int i=0;i<len;++i)
        {
            char curr = s.charAt(i);
            if(curr >= 48 && curr <=57)
            {
                temp = temp*10 + (curr-48);
            }
            else if(curr == '+' || curr =='-')
            {
                ret = ret + sign*temp;
                sign = st.peek() * ((curr == '+')?1:-1);
                temp =0; // whenever we see a sign , we need to reset the temp number
            }
            else if(curr == '(')
            {
                st.push(sign);
            }
            else if(curr == ')')
            {
                st.pop();
            }
            else// can be a blank space
            {
            }
        }
        ret = ret + sign*temp;
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("output is "+new Day11().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
